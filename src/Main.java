class Solution {
    public int binaryGap(int n) {
        // 1. init
        int maxDist = 0;
        int cnt = 0;

        // 2. loop
        while(n > 0) {
            if(n%2 == 1) {
                maxDist = Math.max(maxDist, cnt);
                cnt = 1;
            }
            else {
                if(cnt > 0) cnt++;
            }
            n /= 2;
        }

        return maxDist;
    }
}