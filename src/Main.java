import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 1. init
        int[] res = new int[2];
        List<Info> numList = new ArrayList<>();
        for(int i=0; i<nums.length; i++) {
            numList.add(new Info(nums[i], i));
        }

        // 2. sort
        numList.sort((a, b) -> {
            return a.num - b.num;
        });

        // 3. two pointer
        int l = 0;
        int r = nums.length - 1;
        while(l < r) {
            int cur = numList.get(l).num + numList.get(r).num;

            if(cur < target) {
                l++;
            }
            else if(cur > target) {
                r--;
            }
            else {
                res[0] = numList.get(l).idx;
                res[1] = numList.get(r).idx;
                break;
            }
        }

        return res;
    }
}

class Info {
    int num;
    int idx;

    public Info(int num, int idx) {
        this.num = num;
        this.idx = idx;
    }
}