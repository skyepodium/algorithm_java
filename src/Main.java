import java.util.HashMap;
import java.util.HashSet;

class Main {
    public static void main(String[] args) {

        String a = "a, a, a, a, b,b,b,c, c";

        String[] b = new String[1];
        b[0] = "a";

        Solution sl = new Solution();
        String res = sl.mostCommonWord(a, b);
        System.out.println("res " + res);
    }
}

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        // 1. 정규 표현식으로 영문자가 아닌 문자는 공백1칸으로 변경
        paragraph = paragraph.replaceAll("[^a-zA-Z]", " ");

        // 2. 한칸 이상의 공백을 기준으로 문자열 분리
        String[] p = paragraph.toLowerCase().split(" +");

        // 3. 금지된 단어를 저장할 set
        HashSet<String> s = new HashSet<String>();
        for(String word: banned) {
            s.add(word);
        }

        // 4. 개수를 검사할 map
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        String result = "";
        int cnt = 0;

        for(String word: p) {

            if(s.contains(word)) continue;

            if(!map.containsKey(word)) {
                map.put(word, 1);
            }
            else {
                int cur_cnt = map.get(word);
                map.put(word, cur_cnt + 1);
            }

            if(map.get(word) > cnt) {
                result = word;
                cnt = map.get(word);
            }
        }

        return result;
    }
}