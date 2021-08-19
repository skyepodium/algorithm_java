class Solution {

    int[] d;
    int res = 0;
    int size = 0;
    public int rob(int[] nums) {
        // 1. init
        size = nums.length;
        d = new int[size];

        // 2. exception
        if(size <= 2) {
            return max(nums);
        }

        // 3. tabulation
        d[0] = nums[0];
        d[1] = max(nums[0], nums[1]);
        for(int i=2; i<size; i++) {
            d[i] = max(d[i-2] + nums[i], d[i-1]);
        }

        return d[size-1];
    }

    public int max(int[] arr) {
        res = 0;
        for(int num: arr) {
            res = max(res, num);
        }
        return res;
    }

    public int max(int a, int b){
        return a > b ? a : b;
    }
}