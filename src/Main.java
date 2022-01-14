class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        // 1. init
        int n = arr.length;
        int res = 0;

        // 2. loop
        for(int i=1; i<=n; i=i+2) {
            for(int j=0; j<n-i+1; j++) {
                res += getSum(arr, j, j+i-1);
            }
        }

        return res;
    }

    public int getSum(int[] arr, int start, int end) {
        int res = 0;

        for(int i=start; i<=end; i++) {
            res += arr[i];
        }

        return res;
    }
}