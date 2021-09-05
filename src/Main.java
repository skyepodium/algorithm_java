import java.util.*;

class Solution {
    public int thirdMax(int[] nums) {
        // 1. init
        HashSet<Integer> s = new HashSet<>();
        List<Integer> a = new ArrayList<>();

        for(int i: nums) {
            if(!s.contains(i)) {
                s.add(i);
                a.add(i);
            }
        }

        // 2. sort
        a.sort(Comparator.reverseOrder());

        return a.size() < 3 ? a.get(0) : a.get(2);
    }
}