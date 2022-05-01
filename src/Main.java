import java.util.Stack;

class Solution {
    public boolean backspaceCompare(String s, String t) {
        return refine(s).equals(refine(t));
    }

    public String refine(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char cur = s.charAt(i);
            if(cur != '#') {
                st.add(cur);
            }
            else {
                if(!st.isEmpty()) st.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb.toString();
    }
}