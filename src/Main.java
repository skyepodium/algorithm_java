class Solution {

    int size;
    int[] d;
    int res;

    public int maxSubArray(int[] nums) {
        // 1. init
        size = nums.length;
        d = new int[size];
        res = nums[0];

        go(size-1, nums);

        return res;
    }

    public int go(int idx, int[] nums) {
        if(idx < 1) return nums[0];

        if(d[idx] > 0) return d[idx];

        d[idx] = max(nums[idx], go(idx-1, nums) + nums[idx]);

        res = max(res, d[idx]);

        return d[idx];
    }

    public int max(int a, int b) {
        return a > b ? a : b;
    }
}