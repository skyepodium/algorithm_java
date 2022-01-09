import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for(int i=0; i<nums.length; i++) {
            int x = nums[i];

            if(nums[Math.abs(x) - 1] < 0) {
                res.add(Math.abs(x));
            }else{
                nums[Math.abs(x) - 1] *= -1;
            }
        }
        return res;
    }
}