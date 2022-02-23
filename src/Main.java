class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        // 0. exception
        if(arr.length < 3) return false;

        // 1. init
        int a = 0;
        int b = a+1;
        int c = b+1;

        // 2. loop
        for(int i=0; i<=arr.length - 3; i++) {
            if((arr[i+a] & 1) == 1 && (arr[i+b] & 1) == 1 && (arr[i+c] & 1) == 1) return true;
        }

        return false;
    }
}