import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) {
        int[] s = {1, 2, 3, 9, 10, 12};
        int k = 7;

        Solution sl = new Solution();

        int res = sl.solution(s, k);
        System.out.println(res);
    }
}

class Solution {
    public int solution(int[] scoville, int K) {
        // 1. init
        int answer = 0;

        // 2.priority queue
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num: scoville) {
            pq.add(num);
        }

        // 3. loop
        while(pq.size() >= 2 && pq.peek() < K) {
            int a = pq.poll();
            int b = pq.poll();
            pq.add(a + b * 2);

            answer += 1;
        }

        return pq.peek() >= K ? answer : -1;
    }
}