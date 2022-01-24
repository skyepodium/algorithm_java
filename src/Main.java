import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[] sortByBits(int[] arr) {
        return Arrays.stream(arr)
                .boxed()
                .sorted((a, b) -> {
                    int aOneCnt = Integer.bitCount(a);
                    int bOneCnt = Integer.bitCount(b);
                    return aOneCnt == bOneCnt ? a - b : aOneCnt - bOneCnt;
                })
                .mapToInt(i -> i)
                .toArray();
    }
}

class Main {

}