import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        // 1. int
        int res = 0;
        int maxVal = Arrays.stream(citations).max().getAsInt();
        int n = citations.length;

        // 2. sort
        citations = Arrays.stream(citations).sorted().toArray();

        // 3. lower bound
        for(int i=0; i<=maxVal; i++) {
            int idx = lowerBound(0, n, i, citations);
            int upper = n - idx;
            if(upper >= i) res = Math.max(res, i);
        }

        return res;
    }

    public int lowerBound(int s, int e, int target, int[] c) {
        while(s < e) {
            int mid = s + (e - s) / 2;
            if(c[mid] < target) s = mid + 1;
            else e = mid;
        }
        return e;
    }
}