class Solution {
    public void duplicateZeros(int[] arr) {
        // 1. init
        int[] origin = arr.clone();
        int n = arr.length;
        int arrIdx = 0;

        // 2. loop
        for(int cur: origin) {
            if(arrIdx >= n) break;

            arr[arrIdx] = cur;
            arrIdx += 1;

            if(cur == 0 && arrIdx < n) {
                arr[arrIdx] = cur;
                arrIdx += 1;
            }
        }
     }
}