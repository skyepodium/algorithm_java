import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        // 1. init
        Map<String, Integer> m = new HashMap<>();

        Arrays.stream(completion).forEach(x -> m.put(x, m.getOrDefault(x, 0) + 1));

        // 2. loop
        for(String p: participant) {
            if(!m.containsKey(p) || m.get(p) == 0) return p;

            m.put(p, m.get(p) - 1);
        }

        return "";
    }
}