import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.climbStairs(4));
    }
}

class Solution {
    public int climbStairs(int n) {
        int max_int = 45;

        int d[] = new int[max_int];
        d[0] = 0;
        d[1] = 1;
        d[2] = 2;

        for(int i=3; i<=n; i++) {
            d[i] = d[i-1] + d[i-2];
        }
        return d[n];
    }
}