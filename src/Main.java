import java.util.ArrayList;
import java.util.Stack;

class Solution {
    public String reverseParentheses(String s) {
        // 1. init
        Stack<String> res = new Stack<>();
        res.add("");

        // 2. loop
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);

            if(c == '(') {
                res.add("");
            }
            else if(c == ')') {
                    String t = res.pop();
                    String y = res.pop();
                    res.add(y + new StringBuilder(t).reverse());
            }
            else {
                String t = res.pop();
                res.add(t + c);
            }
            System.out.println("res " + res);
        }

        return String.join("", res);
    }
}

class Main {
    public static void main(String[] args) {
        Solution sl = new Solution();

        String res = sl.reverseParentheses("(abcd)");

        System.out.println("res " + res);

    }
}