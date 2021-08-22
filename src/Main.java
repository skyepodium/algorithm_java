import java.util.HashSet;
import java.util.Stack;

class Solution {
    public String removeDuplicateLetters(String s) {
        // 1. init
        Stack<Character> st = new Stack<>();
        HashSet<Character> seen = new HashSet<>();
        int[] counter = new int[26];
        int size = s.length();

        for(int i=0; i<size; i++) {
            char c = s.charAt(i);
            int order = (int)c - (int)'a';
            counter[order]++;
        }

        for(int i=0; i<size; i++) {
            char c = s.charAt(i);
            int order = (int)c - (int)'a';
            counter[order]--;

            if(seen.contains(c)) continue;

            while(!st.empty() && st.peek() > c && counter[(int)st.peek() - (int)'a'] > 0) {
                seen.remove(st.pop());
            }

            seen.add(c);
            st.add(c);
        }

        String res = "";
        while(!st.empty()) {
            res = st.pop() + res;
        }

        return res;
    }
}

class Main{
    public static void main(String[] args) {
        Solution sl = new Solution();

        String s = "bcabc";
        String res = sl.removeDuplicateLetters(s);

        System.out.println("res " + res);
    }
}