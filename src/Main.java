import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public String solution(String s) {
        String answer = "";

        boolean isFirst = true;
        for(int i=0; i<s.length(); i++) {
            String a  = s.charAt(i) + "";
            if(a.equals(" ")) {
                isFirst = true;
            }
            else {
                if(isFirst) {
                    isFirst = false;
                    a = a.toUpperCase();
                }
                else {
                    a = a.toLowerCase();
                }
            }
            answer += a;
        }

        return answer;
    }
}

class Main {
    public static void main(String[] args) {
        Solution sl = new Solution();
        String res = sl.solution("3people unFollowed me");

        System.out.println("res " + res);
    }
}