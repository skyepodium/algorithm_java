import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
    public int findFinalValue(int[] nums, int original) {
        Set<Integer> s = new HashSet<>(Arrays.stream(nums).boxed().collect(Collectors.toList()));

        while(s.contains(original)) original *= 2;

        return original;
    }
}