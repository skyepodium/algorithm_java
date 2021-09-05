class Solution {
    int[] d;
    public int countPrimes(int n) {
        // 1. exception
        if(n <= 2) return 0;

        // 2. init
        d = new int[n+1];
        int res = 0;

        // 3. eratos
        eratos(n);

        // 4. check
        for(int i=2; i<n; i++) {
            if(d[i] == 0) res++;
        }

        return res;
    }

    public void eratos(int n) {
        for(int i=2; i*i<=n; i++) {
            for(int j=i*2; j<=n; j=j+i) {
                if(d[j] == 0) {
                    d[j] = 1;
                }
            }
        }
    }
}