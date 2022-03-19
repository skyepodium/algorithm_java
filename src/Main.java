class Solution {

    public static int res = 0;
    public static int n = 0;
    public static int[] b;
    public static int t = 0;
    public int findTargetSumWays(int[] nums, int target) {
        // 1. init
        n = nums.length;
        b = nums;
        t = target;
        res = 0;

        // 2. dfs
        go(0, 0);

        return res;
    }

    public static void go(int idx, int val) {
        if(idx >= n) {
            if(val == t) res++;
            return;
        }

        go(idx + 1, val + b[idx]);
        go(idx + 1, val - b[idx]);
    }
}