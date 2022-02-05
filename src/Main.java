import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        // 1. init
        int res = 0;
        Map<Character, Integer> m = new HashMap<>();

        // 2. make counter
        for(int i=0; i<stones.length(); i++) {
            Character c = stones.charAt(i);
            if(m.containsKey(c)) m.put(c, m.get(c) + 1);
            else m.put(c, 1);
        }

        for(int i=0; i<jewels.length(); i++) {
            Character j = jewels.charAt(i);
            if(m.containsKey(j)) res += m.get(j);
        }

        return res;
    }
}