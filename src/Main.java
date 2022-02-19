class Solution {
    public int[] getNoZeroIntegers(int n) {
        // 1. loop
        for(int i=1; i<=n/2 + 1; i++) {
            if(!nonZero(i) || !nonZero(n-i)) continue;

            return new int[]{i, n-i};
        }
        return new int[]{-1, -1};
    }

    // 2. nonZero
    public boolean nonZero(int num) {
        while(num > 0) {
            if(num % 10 == 0) return false;
            num /= 10;
        }
        return true;
    }
}