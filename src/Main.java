import java.util.HashSet;
import java.util.Set;

class Solution {
    public String longestNiceSubstring(String s) {
        // 1. init
        int n = s.length();
        String res = "";

        // 2. loop
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n+1; j++) {
                // 1) set
                boolean isNice = true;
                String cur = s.substring(i, j);
                Set<Character> se = new HashSet<>();
                for(int k=0; k<cur.length(); k++) {
                    char c = cur.charAt(k);
                    se.add(c);
                }

                for(int k=0; k<cur.length(); k++) {
                    char c = cur.charAt(k);
                    if(((int)c >= (int)'a' && !se.contains((char)(c - 32)))
                    || ((int)c < (int)'a' && !se.contains((char)(c + 32)))) {
                        isNice = false;
                        break;
                    }
                }

                if(isNice && res.length() < cur.length()) res = cur;
            }
        }

        return res;
    }
}