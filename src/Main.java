class Solution {
    public int largestAltitude(int[] gain) {
        // 1. init
        int prev = 0;
        int res = 0;

        // 2. loop
        for(int g: gain) {
            prev = prev + g;
            res = Math.max(res, prev);
        }

        return res;
    }
}