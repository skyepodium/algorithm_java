import java.util.HashMap;
import java.util.Stack;

class Main {
    public static void main(String[] args) {
        Solution sl = new Solution();

        String s = "()[]{}";

        Boolean res = sl.isValid(s);

        System.out.println(res);
    }
}

class Solution {
    public boolean isValid(String s) {

        // 1. 여는 괄호 기준으로 닫는 괄호 map 생성
        HashMap<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('[', ']');
        map.put('(', ')');

        // 2. 스택 생성
        Stack<Character> stack = new Stack<>();

        int size = s.length();
        for(int i=0; i<size; i++) {
            char cur = s.charAt(i);

            // 3. 스택이 들어있는 경우
            if(!stack.empty()) {

                // 현재가 시작 괄호이면 push
                if(map.get(cur) != null) {
                    stack.add(cur);
                }
                // 현재가 닫는 과로인데 top의 닫는 괄호가 아니면 종료
                else {
                    if(map.get(stack.pop()) != cur) return false;
                }
            }
            // 4. 스택이 비어있는 경우
            else{
                stack.add(cur);
                // 현재가 닫는 괄호이면 종료
                if(map.get(cur) == null) return false;
            }
        }

        // 5. 여는 괄호가 하나라도 남아있으면 종료
        if(!stack.empty()) return false;

        return true;
    }
}