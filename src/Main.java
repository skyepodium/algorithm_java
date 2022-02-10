import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> s = new HashSet<>();
        for(int a: arr) {
            if(s.contains(a * 2) || ((a % 2) == 0 && s.contains(a / 2))) return true;

            s.add(a);
        }
        return false;
    }
}