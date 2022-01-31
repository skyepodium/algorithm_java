import java.util.*;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // 1. init
        List<String> res = new ArrayList<>();
        Map<String, Integer> m = new HashMap<>();
        List<Info> wList = new ArrayList<>();
        int idx = 0;

        // 2. counter
        Arrays.stream(words).forEach(x -> {
            if(m.containsKey(x)) m.put(x, m.get(x) + 1);
            else m.put(x, 1);
        });

        // 3. map to list
        m.keySet().forEach(x -> {
            wList.add(new Info(x, m.get(x)));
        });

        // 4. sort
        wList.sort((a, b) -> {
            if(a.cnt == b.cnt) return a.w.compareTo(b.w);
            else return b.cnt - a.cnt;
        });

        // 5. loop
        for(Info info: wList) {
            if(idx >= k) break;
            res.add(info.w);
            idx++;
        }

        return res;
    }
}

class Info {
    String w;
    int cnt;
    public Info(String w, int cnt) {
        this.w = w;
        this.cnt = cnt;
    }
}