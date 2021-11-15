class Solution {
    public int binaryGap(int n) {
        // 1. int to binary str
        String s = "";
        while(n > 0) {
            s += n%2;
            n /= 2;
        }

        int cnt = 0;
        int maxDist = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '1') {
                maxDist = Math.max(maxDist, cnt);
                cnt = 1;
            }
            else {
                if(cnt > 0) cnt += 1;
            }
        }

        return maxDist;
    }
}