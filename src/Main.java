class Main {
    public int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];


        int cur = 0;
        for(int i=0; i<nums.length; i++) {
            cur += nums[i];
            result[i] = cur;
        }

        return result;
    }
}