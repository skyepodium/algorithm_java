import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean hasAllCodes(String s, int k) {
        // 1. init
        int n = s.length();
        int cnt = 1 << k;
        Set<String> seen = new HashSet<>();

        // 2. loop
        for(int i=0; i<n-k+1; i++) {
            String cur = s.substring(i, i+k);
            if(!seen.contains(cur)) {
                cnt--;
                seen.add(cur);
            }
            if(cnt == 0) return true;
        }
        
        return false;
    }
}