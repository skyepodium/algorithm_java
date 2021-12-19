class Solution {
    public int xorOperation(int n, int start) {
        int result = start;
        for(int i=start+2; i <= start + 2 * (n-1); i+=2) {
            result ^= i;
        }
        return result;
    }
}