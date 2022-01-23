import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // 1. init
        Map<Integer, Integer> m = new HashMap<>();

        // 2. loop
        for(int i=0; i<nums.length; i++) {
            int cur = nums[i];
            if(m.containsKey(cur) && i - m.get(cur) <= k) {
                return true;
            }

            m.put(cur, i);
        }

        return false;
    }
}