import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxNumberOfBalloons(String text) {
        // 1. init
        Map<String, Integer> m = new HashMap<>();
        Arrays.stream(text.split("")).forEach(c -> m.put(c, m.getOrDefault(c, 0) + 1));

        return min5(m.getOrDefault("b", 0), m.getOrDefault("a", 0), m.getOrDefault("l", 0) / 2, m.getOrDefault("o", 0) / 2, m.getOrDefault("n", 0));
    }

    public int min5(int a, int b, int c, int d, int e) {
        return Math.min(a, Math.min(b, Math.min(c, Math.min(d, e))));
    }
}