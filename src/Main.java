import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // 1. init
        int size = temperatures.length;
        int[] res = new int[size];
        Stack<Integer> s = new Stack<>();

        // 2. loop
        for(int i=0; i<size; i++) {
            int cur = temperatures[i];
            while(!s.empty() && temperatures[s.peek()] < cur) {
                int top = s.pop();
                res[top] = i - top;
            }

            s.add(i);
        }

        return res;
    }
}