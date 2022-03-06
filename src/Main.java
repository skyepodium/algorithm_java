class Solution {
    public int[] replaceElements(int[] arr) {
        // 1. init
        int n = arr.length;
        int[] res = new int[n];
        res[n-1] = -1;
        int curMax = arr[n-1];

        // 2. loop
        for(int i=n-2; i>=0; i--) {
            if(arr[i+1] > curMax) curMax = arr[i+1];
            res[i] = curMax;
        }

        return res;
    }
}