import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        // 1. init
        Map<Integer, Integer> m = new HashMap<>();
        int res = 0;

        // 2. counter
        for(int[] d: dominoes) {
            int num = Math.max(d[0], d[1]) * 10 + Math.min(d[0], d[1]);
            m.put(num, m.getOrDefault(num, 0) + 1);
        }

        // 3. for loop
        for(Integer c: m.values()) {
            res += c * (c - 1) / 2;
        }

        return res;
    }
}