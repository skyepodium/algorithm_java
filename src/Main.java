import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int missingNumber(int[] nums) {
        Set<Integer> s = new HashSet<>();
        Arrays.stream(nums).forEach(s::add);

        for(int i=0; i<=nums.length; i++) {
            if(!s.contains(i)) return i;
        }
        return -1;
    }
}