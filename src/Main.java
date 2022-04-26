import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public long solution(int n, int[] works) {
        // 1. init
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
        Arrays.stream(works).forEach(pq::add);

        // 2. loop
        while(n > 0 && !pq.isEmpty()) {
            int cur = pq.poll();
            if(cur >= 2) pq.add(cur-1);
            n--;
        }

        // 3. res
        return pq.stream().mapToLong(x -> (long) x *x)
                .reduce(0, Long::sum);
    }
}

class Main {
    public static void main(String[] args) {
//        int[] works = {4, 3, 3};
//        int n = 4;

//        int[] works = {2, 1, 2};
//        int n = 1;

        int[] works = {1, 1};
        int n = 3;


        Solution sl = new Solution();
        long res = sl.solution(n, works);

        System.out.println("res " + res);
    }
}