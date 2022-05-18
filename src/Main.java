import java.util.Arrays;

class Solution {
    public int[] buildArray(int[] nums) {
        return Arrays.stream(nums).map(num -> nums[num]).toArray();
    }
}