import java.util.Stack;

class Solution {
    public int solution(String s) {

        Stack<Character> stack = new Stack<>();

        int size = s.length();
        for(int i=0; i<size; i++) {
            char cur = s.charAt(i);

            if(!stack.empty()) {
                if(stack.peek() == cur) {
                    stack.pop();
                }
                else{
                    stack.add(cur);
                }
            }
            else{
                stack.add(cur);
            }
        }
        if(!stack.empty()) return 0;

        return 1;
    }
}

class Main {
    public static void main(String[] args) {
        Solution sl = new Solution();

        int res = sl.solution("baabaa");

        System.out.println("res " + res);
    }
}