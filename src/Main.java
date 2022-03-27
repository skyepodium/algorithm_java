import java.util.stream.IntStream;

class Solution {
    public int[] countBits(int n) {
        return IntStream
                .range(0, n+1)
                .map(x -> {
                    int count = 0;
                    while(x > 0) {
                        if(x%2 == 1) count++;
                        x /= 2;
                    }
                    return count;
                })
                .toArray();
    }
}