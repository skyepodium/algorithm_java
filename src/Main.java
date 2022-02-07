import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[][] clothes) {
        // 1. 초기화
        int res = 0;
        Map<String, Integer> m = new HashMap<>();

        // 2. 카운트
        for(String[] c: clothes) {
            m.put(c[1], m.getOrDefault(c[1], 0) + 1);
        }

        // 3. 인수분해
        for(Integer x: m.values()) {
            res *= x + 1;
        }

        return res - 1;
    }
}