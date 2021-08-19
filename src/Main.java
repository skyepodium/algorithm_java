class Solution {
    int d[];
    public int climbStairs(int n) {
        d = new int[n+1];

        return go(n);
    }

    public int go(int i) {
        if(i <= 2) return i;

        if(d[i] > 0) return d[i];

        d[i] = go(i-2) + go(i-1);

        return d[i];
    }
}