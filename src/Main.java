class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // 1. init
        int l = 0;
        int r = numbers.length - 1;
        int[] answer= {0, 0};

        // 2. two pointer
        while(l <= r) {
            int sumVal = numbers[l] + numbers[r];

            if(sumVal < target) {
                l++;
            }
            else if(sumVal > target) {
                r--;
            }
            else {
                answer[0] = l+1;
                answer[1] = r+1;
                return answer;
            }
        }
        return answer;
    }
}