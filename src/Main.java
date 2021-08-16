import java.util.HashMap;
import java.util.Stack;

class Main {
    public static void main(String[] args) {

        Solution sl = new Solution();

        int res = sl.solution("[](){}");
        System.out.println("res " + res);
    }
}

class Solution {
    HashMap<Character, Character> d = new HashMap<>();
    public int solution(String s) {

        // 1. set HashMap
        d.put('{', '}');
        d.put('(', ')');
        d.put('[', ']');

        // 2. check length
        int size = s.length();

        // 3. check and shift
        int answer = 0;
        for(int i=0; i<size; i++) {
            if(checkValid(s)) answer++;
            s = shift(s);
        }

        return answer;
    }

    public String shift(String s) {
        int size = s.length();
        return s.substring(size-1) + s.substring(0, size-1);
    }

    public boolean checkValid(String s) {
        int size = s.length();
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<size; i++) {
            char cur = s.charAt(i);

            if(d.get(cur) != null) {
                stack.add(cur);
            }
            else {
                if(stack.isEmpty()) return false;

                char top = stack.pop();
                if(d.get(top) != cur) {
                    return false;
                }
            }
        }

        if(!stack.isEmpty()) return false;

        return true;
    }
}