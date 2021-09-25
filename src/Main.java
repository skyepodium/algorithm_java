class Solution {
    public int singleNumber(int[] nums) {
        // 1. init
        int res = nums[0];
        int size = nums.length;

        // 2. xor
        for(int i=1; i<size; i++) {
            res ^= nums[i];
        }

        return res;
    }
}

class Main {
    public static void main(String[] args) {
        Solution sl = new Solution();
        int[] nums = {2, 2, 1};
        int res = sl.singleNumber(nums);

        System.out.println("res " + res);
    }
}