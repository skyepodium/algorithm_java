class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        return binarySearch(l,r, nums, target);
    }

    public int binarySearch(int l, int r, int[] nums, int target) {
        while(l <= r) {
            int mid = (l+r) / 2;

            if(nums[mid] < target) {
                l++;
            }
            else if(nums[mid] > target) {
                r--;
            }
            else {
                return mid;
            }
        }
        return -1;
    }
}

class Main {
    public static void main(String[] args) {

    }
}