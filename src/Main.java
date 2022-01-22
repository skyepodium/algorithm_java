import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 1. init
        int[] res = new int[2];
        Map<Integer, Integer> m = new HashMap<>();

        // 2. loop
        for(int i=0; i<nums.length; i++) {
            int cur = nums[i];
            int remain = target - cur;
            if(m.containsKey(remain)) {
                int idx = m.get(remain);
                res[0] = idx;
                res[1] = i;
                break;
            }
            else {
                m.put(cur, i);
            }
        }

        return res;
    }
}