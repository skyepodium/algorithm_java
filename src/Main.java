class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // 1. init
        int size = numbers.length;
        int[] answer= {0, 0};

        for(int i=0; i<size-1; i++) {
            int l = i+1;
            int r = size-1;
            int remain = target - numbers[i];

            while(l<=r) {
                int mid = l + (r-l) / 2;
                if(numbers[mid] < remain) {
                    l = mid + 1;
                }
                else if(numbers[mid] > remain) {
                    r = mid - 1;
                }
                else {
                    answer[0] = i+1;
                    answer[1] = mid + 1;
                    return answer;
                }
            }
        }
        return answer;
    }
}