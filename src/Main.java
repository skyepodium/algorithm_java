import java.util.Arrays;

class Solution {
    public int solution(int n) {
        // 1. init
        int[] d = new int[n+1];
        for(int i=0; i<=n; i++) d[i] = 1;

        // 2. eratos
        for(int i=2; i*i<=n; i++) {
            for(int j=i*2; j<=n; j+=i) {
                d[j] = 0;
            }
        }
        d[0] = d[1] = 0;

        return Arrays.stream(d).sum();
    }
}