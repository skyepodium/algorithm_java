import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

class Solution {
    public int maximumWealth(int[][] accounts) {
        return Arrays.stream(accounts).mapToInt(x -> Arrays.stream(x).sum()).max().getAsInt();
    }
}