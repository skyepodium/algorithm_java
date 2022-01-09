class Solution {
    public int findNumbers(int[] nums) {
        // 1. init
        int res = 0;

        // 2. loop
        for(int i=0; i<nums.length; i++) {
            int x = nums[i];

            int cnt=0;
            while(x>0) {
                x /= 10;
                cnt++;
            }
            if(cnt%2==0) res++;
        }

        return res;
    }
}