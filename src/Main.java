class Solution {

    int size, pivotIdx;
    public int search(int[] nums, int target) {
        // 0. init
        size = nums.length;

        // 1. find min idx
        pivotIdx = findMinIdx(0, nums.length-1, nums);

        return binarySearch(0, size - 1, nums, target);
    }

    public int findMinIdx(int l, int r, int[] nums){
        while(l < r) {
            int mid = l + (r-l) / 2;

            if(nums[mid] > nums[r]) {
                l = mid + 1;
            }
            else {
                r = mid;
            }
        }
        return l;
    }

    public int getOriginIdx(int curIdx) {
        if (curIdx + pivotIdx >= size) {
            return curIdx + pivotIdx - size;
        }
        else {
            return curIdx + pivotIdx;
        }
    }

    public int binarySearch(int l, int r, int[] nums, int target) {
        while(l <= r) {
            int mid = l + (r-l) / 2;
            int originMidIdx = getOriginIdx(mid);
            if(nums[originMidIdx] < target) {
                l = mid + 1;
            }
            else if(nums[originMidIdx] > target){
                r = mid - 1;
            }
            else {
                return originMidIdx;
            }
        }
        return -1;
    }
}

class Main {
    public static void main(String[] args) {

    }
}