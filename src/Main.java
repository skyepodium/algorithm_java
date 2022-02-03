import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // 1. init
        AtomicInteger res = new AtomicInteger();
        Map<Integer, Integer> m = new HashMap<>();

        // 2. loop
        Arrays.stream(nums1).forEach(x -> Arrays.stream(nums2).forEach(y -> {
            if(m.containsKey(x+y)) m.put(x+y, m.get(x+y)+1);
            else m.put(x+y, 1);
        }));

        // 2. loop
        Arrays.stream(nums3).forEach(x -> Arrays.stream(nums4).forEach(y -> {
            if(m.containsKey(0 - (x+y))) {
                res.addAndGet(m.get(0 - (x + y)));
            }
        }));


        return res.get();
    }
}