import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String[] gems) {
        // 1. init
        int totalCnt = new HashSet<>(Arrays.stream(gems).collect(Collectors.toList())).size();
        int n = gems.length;
        Map<String, Integer> c = new HashMap<>();
        int startIdx = 0;
        int endIdx = n-1;

        // 2. two pointer
        int s = 0;
        for(int e=0; e<n; e++) {
            String cur = gems[e];
            c.put(cur, c.getOrDefault(cur, 0) + 1);

            while(c.size() >= totalCnt) {
                if(endIdx - startIdx > e - s) {
                    startIdx = s;
                    endIdx = e;
                }

                String startVal = gems[s];
                c.put(startVal, c.get(startVal) - 1);
                if(c.get(startVal) == 0) c.remove(startVal);
                s++;
            }
        }

        return new int[]{startIdx+1, endIdx+1};
    }
}