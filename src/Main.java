import java.util.ArrayList;
import java.util.List;

class Solution {
    public long[] solution(long[] numbers) {
        // 1. init
        List<Long> res = new ArrayList<>();

        // 2. loop
        for(long n: numbers) {
            long val = 0;

            if(n % 2 == 0) {
                val = n + 1;
            }
            else {
                String binNum = intToBinary(n);
                int binNumLen = binNum.length();

                int idx = binNum.lastIndexOf("0");
                if(idx == -1) {
                    idx = binNumLen - 1;
                }
                else {
                    idx = binNumLen - idx - 2;
                }
                val = n + (1L << idx);
            }
            res.add(val);
        }
        return res.stream().mapToLong(x -> x).toArray();
    }

    public String intToBinary(long n) {
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            sb.append(n%2);
            n /= 2;
        }
        return sb.reverse().toString();
    }
}