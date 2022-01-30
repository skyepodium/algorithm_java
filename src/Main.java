import java.util.HashSet;
import java.util.Set;

class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        // 1. init
        String[] textList = text.split(" ");
        int res = 0;
        Set<Character> c = new HashSet<>();

        for(int i=0; i<brokenLetters.length(); i++) {
            c.add(brokenLetters.charAt(i));
        }


        // 2. loop
        for(String w: textList) {
            boolean isOk = true;
            for(int i=0; i<w.length(); i++) {
                if(c.contains(w.charAt(i))) {
                    isOk = false;
                    break;
                }
            }
            if(isOk) res++;
        }


        return res;
    }
}