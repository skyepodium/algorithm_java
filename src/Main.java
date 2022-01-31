import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

class Solution {
    public int maximumWealth(int[][] accounts) {
        // 1. init
        AtomicInteger result = new AtomicInteger();

        Arrays.stream(accounts).forEach(x -> {
            result.set(Math.max(result.get(), getSum(x)));
        });

        return result.get();
    }

    public int getSum(int[] a) {
        int res = 0;
        for(int i=0; i<a.length; i++) {
            res += a[i];
        }
        return res;
    }
}