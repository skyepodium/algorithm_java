class Main {
    public static void main(String[] args) {
        Solution sl = new Solution();

        int[] nums = {1, 2, 3, 4};
        int[] res = sl.productExceptSelf(nums);

        for(int num: res) {
            System.out.println(num);
        }
    }
}

class Solution {
    public int[] productExceptSelf(int[] nums) {

        int size = nums.length;
        int[] leftTimes = new int[size];
        int[] rightTimes = new int[size];
        int[] result = new int[size];

        // 1. 초기값 설정
        leftTimes[0] = nums[0];
        rightTimes[size-1] = nums[size-1];

        // 2. 왼쪽 누적곱을 만든다.
        for(int i=1; i<size; i++) {
            leftTimes[i] = leftTimes[i-1] * nums[i];
        }

        // 3. 오른쪽 누접곱을 만든다.
        for(int i=size-2; i>=0; i--) {
            rightTimes[i] = rightTimes[i+1] * nums[i];
        }

        // 4. 자신을 제외한 양옆의 곱을 계산한다.
        for(int i=0; i<size; i++) {
            int leftVal = i-1 >= 0 ? leftTimes[i-1] : 1;
            int rightVal = i+1 <= size-1 ? rightTimes[i+1] : 1;
            result[i] = leftVal * rightVal;
        }

        return result;
    }
}