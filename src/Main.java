import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

class Solution {
    List<List<Integer>> lList;
    int m;
    public int solution(String[][] relation) {
        // 1. init
        int res = 0;
        int n = relation.length;
        m = relation[0].length;
        Set<String> idxSet = new HashSet<>();
        lList = new ArrayList<>();

        // 2. go
        go(0, new Stack<>());

        // 3. sort
        lList.sort(Comparator.comparingInt(List::size));

        // 4. loop
        for(List<Integer> l: lList) {
            // 1) uniqueness
            Set<String> cSet = new HashSet<>();
            l.forEach(x -> cSet.add(Integer.toString(x)));

            AtomicBoolean isPossible = new AtomicBoolean(true);

            idxSet.stream().forEach(idx -> {
                int cnt = 0;

                for(String x: idx.split("")) {
                    if(cSet.contains(x)) cnt++;
                }

                if(cnt == idx.length()) {
                    isPossible.set(false);
                }
            });

            if(!isPossible.get()) continue;

            // 2)  make key
            List<String> keyList = new ArrayList<>();
            for(String[] c: relation) {
                String key = "";
                for(int x: l) {
                    key += c[x] + "_";
                }
                keyList.add(key);
            }

            // 3) size check
            Set<String> s = new HashSet<>(keyList);
            if(s.size() < n) continue;

            // 4) add key
            String nKey = "";
            for(int i: l) {
                nKey += Integer.toString(i);
            }
            idxSet.add(nKey);
            res++;
        }

        return res;
    }

    public void go(int idx, Stack<Integer> l) {
        if(idx >= m) {
            if(l.size() > 0) {
                lList.add(new ArrayList<>(l));
            }
            return;
        }

        l.add(idx);
        go(idx + 1, l);
        l.pop();

        go(idx + 1, l);
    }
}

public class Main {
    public static void main(String[] args) {
        String[][] relation = {{"100","ryan","music","2"}};

        Solution sl = new Solution();

        int res = sl.solution(relation);

        System.out.println("res " + res);
    }
}