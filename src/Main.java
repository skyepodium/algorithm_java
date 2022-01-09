import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        // 1. init
        String[] sList = s.split(" ");
        Map<Character, String> m = new HashMap<>();
        Set<String> e = new HashSet<>();

        // 2. exception
        if(pattern.length() != sList.length) return false;

        // 3. loop
        for(int i=0; i<sList.length; i++) {
            char a = pattern.charAt(i);
            String b = sList[i];

            if(m.containsKey(a)) {
                if(!m.get(a).equals(b)) {
                    return false;
                }
            }else{
                if(e.contains(b)) return false;
                m.put(a, b);
                e.add(b);
            }
        }
        return true;
    }
}