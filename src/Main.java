import java.util.Stack;

class Solution {
    public String removeDuplicates(String s) {
        // 1. init
        Stack<Character> st = new Stack<>();

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);

            if(st.size() > 0 && st.peek() == c) {
                while(st.size() > 0 && st.peek() == c) st.pop();
            }
            else {
                st.add(c);
            }
        }

        // 3. res
        StringBuilder res = new StringBuilder();
        while(st.size() > 0) res.append(st.pop());
        return res.reverse().toString();
    }
}