import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        // 1. init
        long maxVal = Arrays.stream(times).max().getAsInt();
        long res = maxVal * n;
        long s = 0, e = maxVal * n;

        // 2. binary search
        while(s < e) {
            long mid = s + (e - s) / 2;
            long cnt = calTime(mid, times);

            if(cnt < n) {
                s = mid + 1;
            }
            else {
                res = Math.min(res, mid);
                e = mid;
            }
        }

        return res;
    }

    public long calTime(long a, int[] times) {
        return Arrays.stream(times).mapToLong(x -> a/x)
                .reduce(0, Long::sum);
    }
}
