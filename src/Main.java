class Solution {
    public int solution(int n) {
        // 1. init
        int res = 0;
        int[] d = new int[n+1];
        for(int i=1; i<=n; i++) d[i] = d[i-1] + i;

        // 2. two pointer
        int s = 0;
        int e = 0;
        while(s <= e && e < n + 1) {
            int cur = d[e] - d[s];
            if(cur <= n) {
                if(cur == n) res++;
                e++;
            }
            else {
                s++;
            }
        }

        return res;
    }
}