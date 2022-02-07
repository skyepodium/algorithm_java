import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 1. init
        Map<String, Integer> c = new HashMap<>();
        Map<String, List<Info>> i = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int[] res;

        for(int idx=0; idx<genres.length; idx++) {
            String g = genres[idx];
            int p = plays[idx];

            c.put(g, c.getOrDefault(g, 0) + p);

            List<Info> tempList;
            if (i.containsKey(g)) tempList = i.get(g);
            else tempList = new ArrayList<>();
            tempList.add(new Info(idx, p));
            i.put(g, tempList);
        }

        List<Count> l = new ArrayList<>();
        for(String key: c.keySet()) {
            l.add(new Count(key, c.get(key)));
        }

        l.sort((a, b) -> b.count - a.count);

        for(Count cur: l) {
            List<Info> songList = i.get(cur.genre);
            songList.sort((a, b) -> {
                if(a.count == b.count) return a.idx - b.idx;
                else return b.count - a.count;
            });
            result.add(songList.get(0).idx);
            if(songList.size() >= 2) result.add(songList.get(1).idx);
        }

        res = new int[result.size()];
        for(int idx=0; idx<res.length; idx++) {
            res[idx] = result.get(idx);
        }

        return res;
    }
}
class Count {
    String genre;
    int count;
    public Count(String genre, int count) {
        this.genre = genre;
        this.count = count;
    }
}
class Info {
    int idx;
    int count;
    public Info(int idx, int count) {
        this.idx = idx;
        this.count = count;
    }
}