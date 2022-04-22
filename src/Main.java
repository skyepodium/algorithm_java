import java.util.PriorityQueue;
import java.util.stream.IntStream;

class Solution {
    public int dominantIndex(int[] nums) {
        // 1. exception
        if(nums.length < 2) return 0;

        // 2. init
        PriorityQueue<Info> pq = new PriorityQueue<>((a, b) -> b.val - a.val);

        IntStream.range(0, nums.length).forEach(x -> pq.add(new Info(nums[x], x)));

        Info first = pq.poll();
        Info second = pq.poll();

        return first.val >= 2 * second.val ? first.idx : -1;
    }
}

class Info {
    public int val;
    public int idx;

    public Info(int val, int idx) {
        this.val = val;
        this.idx = idx;
    }
}