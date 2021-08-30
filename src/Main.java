import java.util.Stack;

class Solution {
    public String solution(String number, int k) {
        // 1. init
        Stack<Character> s = new Stack<>();
        String res = "";
        int size = number.length();

        for(int i=0; i<size; i++) {
            char c = number.charAt(i);
            while(k > 0 && !s.empty() && s.peek() < c) {
                k--;
                s.pop();
            }
            s.add(c);
        }

        while(k > 0) {
            s.pop();
            k--;
        }

        while(!s.empty()) {
            res = s.pop() + res;
        }

        return res;
    }
}