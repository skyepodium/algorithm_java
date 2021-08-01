import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.climbStairs(1));
    }
}

class Solution {
    public int climbStairs(int n) {

        if (n <= 2) return n;

        int[] d = new int[n+1];

        d[0] = 0;
        d[1] = 1;
        d[2] = 2;

        for(int i=3; i<=n; i++) {
            d[i] = d[i-1] + d[i-2];
        }
        return d[n];
    }
}