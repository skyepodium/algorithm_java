import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 1. init
        int n = nums.length;
        Deque<Integer> dq = new ArrayDeque<>();
        int[] res = new int[n - k + 1];
        int idx = 0;

        // 2. loop
        for(int i=0; i<n; i++) {
            // 1) over size
            if(!dq.isEmpty() && dq.peekFirst() <= i - k) dq.pollFirst();

            // 2) make front biggest
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) dq.pollLast();

            // 3) insert dq
            dq.add(i);

            // 4) update
            if(i >= k - 1) res[idx++] = nums[dq.peekFirst()];
        }

        return res;
    }
}