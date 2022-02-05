import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 1. init
        Map<Character, Integer> m = new HashMap<>();
        int n = s.length();
        int res = 0;
        int l = 0;

        // 2. loop
        for(int r=0; r<n; r++) {
            char c = s.charAt(r);

            if(m.containsKey(c)) {
                l = Math.max(l, m.get(c) + 1);
            }

            m.put(c, r);

            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}