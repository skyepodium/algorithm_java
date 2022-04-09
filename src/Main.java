import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class KthLargest {
    private PriorityQueue<Integer> pq;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;

        this.pq = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        Arrays.stream(nums).forEach(x -> pq.add(x));

        while(pq.size() > k) pq.poll();
    }

    public int add(int val) {
        this.pq.add(val);

        while(pq.size() > k) pq.poll();

        return pq.peek();
    }
}
