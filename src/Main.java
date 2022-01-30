import java.util.*;

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // 1. init
        Map<Integer, Integer> m = new HashMap<>();
        List<Integer> aList = new ArrayList<>();
        List<Integer> bList = new ArrayList<>();
        int[] res = new int[arr1.length];

        // 2. loop
        for(int i=0; i<arr2.length; i++) {
            m.put(arr2[i], i);
        }

        // 3. search
        for(int i=0; i<arr1.length; i++) {
            int cur = arr1[i];

            if(m.containsKey(cur)) {
                aList.add(cur);
            }else{
                bList.add(cur);
            }
        }

        aList.sort(Comparator.comparingInt(m::get));
        bList.sort(Comparator.comparingInt(a -> a));

        aList.addAll(bList);

        return aList.stream().mapToInt(Integer::intValue).toArray();
    }
}