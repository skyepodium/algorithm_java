class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // 1. init
        int n = cost.length;
        int[] d = new int[n+1];
        for(int i=0; i<=n; i++) d[i] = Integer.MAX_VALUE;

        // 2. dp - bottom up
        d[0] = cost[0];
        d[1] = cost[1];
        for(int i=0; i<n; i++) {
            if(i+1 <= n) {
                int c = i + 1 >= n ? 0 : cost[i+1];
                d[i+1] = Math.min(d[i+1], d[i] + c);
            }

            if(i+2 <= n) {
                int c = i + 2 >= n ? 0 : cost[i+2];
                d[i+2] = Math.min(d[i+2], d[i] + c);
            }
        }

        return d[n];
    }
}
