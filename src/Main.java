import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> commonChars(String[] words) {
        // 1. init
        int n = words.length;
        String origin = words[0];
        List<String> res = new ArrayList<>();

        // 2. loop
        for(int i=0; i<origin.length(); i++) {
            char c = origin.charAt(i);
            int cnt = 0;
            for(int j=0; j<n; j++) {
                String cur = words[j];
                for(int k=0; k<cur.length(); k++) {
                    if(cur.charAt(k) == c) {
                        cnt++;
                        break;
                    }
                }
            }
            if(cnt == n) {
                res.add(c + "");
                for(int q=0; q<n; q++) {
                    words[q] = words[q].replaceFirst(c+"", "");
                }
            }
        }

        return res;
    }
}

class Main {
    public static void main(String[] args) {

    }
}