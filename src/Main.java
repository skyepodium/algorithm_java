import java.util.Arrays;

class Solution {
    public int arraySign(int[] nums) {
        int res = 1;

        for(int num: nums) {
            if(num == 0) res = 0;
            else if(num < 0) res *= -1;
        }

        return res;
    }
}