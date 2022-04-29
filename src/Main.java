import java.util.Arrays;

class Solution {
    public int specialArray(int[] nums) {
        // 1. init
        int maxVal = Arrays.stream(nums).max().orElse(0);
        int res = -1;

        // 2. binary search
        int s = 0, e = maxVal;
        while(s <= e) {
            int mid = s + (e - s) / 2;
            int cnt = calCnt(mid, nums);
            if(cnt > mid) {
                s = mid + 1;
            }
            else if(cnt == mid) {
                return mid;
            }
            else {
                e = mid - 1;
            }
        }

        return res;
    }

    public int calCnt(int mid, int[] nums) {
        int res = 0;
        for(int x: nums) {
            if(x >= mid) res++;
        }
        return res;
    }
}