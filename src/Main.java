import java.util.HashMap;
import java.util.Map;

class Solution {
    public char findTheDifference(String s, String t) {
        // 1. init
        char[] a = new char[26];
        char res = 'a';

        for(int i=0; i<t.length(); i++) {
            char c = t.charAt(i);
            int idx = (int)c - (int)'a';
            a[idx]++;
        }

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            int idx = (int)c - (int)'a';
            a[idx]--;
        }

        for(int i=0; i<26; i++) {
            if(a[i] > 0) {
                res = (char)(i + (int)'a');
                break;
            }
        }

        return res;
    }
}