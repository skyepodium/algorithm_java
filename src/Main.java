import java.util.HashSet;

class Solution {
    public boolean solution(String[] phone_book) {
        // 1. init
        HashSet<String> s = new HashSet<>();
        for(String p: phone_book) {
            s.add(p);
        }

        // 2. loop
        for(String p: phone_book) {
            int size = p.length();
            String cur = "";
            for(int i=0; i<size; i++) {
                cur += p.charAt(i);
                if(s.contains(cur) && !cur.equals(p)) {
                    return false;
                }
            }
        }
        return true;
    }
}