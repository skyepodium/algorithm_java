import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxOperations(int[] nums, int k) {
        // 1. init
        Map<Integer, Integer> m = new HashMap<>();
        Arrays.stream(nums).forEach(x -> m.put(x, m.getOrDefault(x, 0) + 1));
        int n = nums.length;
        int res = 0;

        // 2. loop
        for(int num: nums) {
            int remain = k - num;
            if(num == remain && m.getOrDefault(remain, 0) <= 1) continue;
            if(m.getOrDefault(remain, 0) < 1 || m.getOrDefault(num, 0) < 1) continue;

            res++;
            m.put(remain, m.get(remain) - 1);
            m.put(num, m.get(num) - 1);
        }

        return res;
    }
}