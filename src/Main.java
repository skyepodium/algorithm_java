import java.util.ArrayList;
import java.util.List;

class Solution {

    public static List<Integer> sqNums = new ArrayList<>();
    public static int[] d;
    public int numSquares(int n) {
        // 1. init
        d = new int[n+1];
        for(int i=0; i<=n; i++) {
            d[i] = 10000;
        }

        for(int i=1; i<101; i++) {
            int sqNum = i * i;
            sqNums.add(sqNum);
            if(sqNum <= n) {
                d[sqNum] = 1;
            }

        }

        // 2. bottom up
        for(int i=1; i<=n; i++) {
            for(Integer sqNum: sqNums) {
                if(i + sqNum <= n) {
                    d[i + sqNum] = Math.min(d[i + sqNum], d[i] + 1);
                }
                else {
                    break;
                }

            }
        }

        return d[n];
    }
}