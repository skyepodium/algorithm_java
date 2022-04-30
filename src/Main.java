class Solution {
    public int solution(int[] money) {
        // 1. init
        int n = money.length;
        int[] a = new int[n];
        int[] b = new int[n];
        a[0] = money[0];
        a[1] = money[0];
        b[1] = money[1];

        // 2. bottom up
        for(int i=2; i<n-1; i++) {
            a[i] = Math.max(a[i-2] + money[i], a[i-1]);
        }

        for(int i=2; i<n; i++) {
            b[i] = Math.max(b[i-2] + money[i], b[i-1]);
        }

        return Math.max(a[n-2], b[n-1]);
    }
}