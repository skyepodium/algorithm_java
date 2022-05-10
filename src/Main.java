class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        // 1. init
        int maxInt = 101;
        int[] c = new int[maxInt];
        int[] d = new int[maxInt];
        int n = nums.length;
        int[] res = new int[n];

        // 2. loop
        for(int num: nums) {
            c[num]++;
        }

        int prev = 0;
        for(int i=0; i<maxInt; i++) {
            if(c[i] == 0) continue;
            d[i] = prev;
            prev += c[i];
        }

        for(int i=0; i<n; i++) {
            int num = nums[i];
            res[i] = d[num];
        }

        return res;
    }
}