import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // 1. init
        int size1 = nums1.length;
        int size2 = nums2.length;
        ArrayList<Integer> res = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        for(int i=0; i<size1; i++) {
            if(i >= 1 && nums1[i] == nums1[i-1]) {
                continue;
            }

            int val = nums1[i];

            if(binarySearch(0, size2-1, nums2, val) != -1) {
                res.add(val);
            }
        }
        int resSize = res.size();
        int[] result = new int[resSize];
        for(int i=0; i<resSize; i++) {
            result[i] = res.get(i);
        }

        return result;
    }

    public int binarySearch(int l, int r, int[] nums, int target) {
        while(l <= r) {
            int mid = l + (r-l) / 2;

            if(nums[mid] < target) {
                l = mid + 1;
            }
            else if(nums[mid] > target) {
                r = mid - 1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
}