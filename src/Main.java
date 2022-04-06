import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Main {
    public static void main(String[] args) {

        Solution sl = new Solution();
        int[] nums = {1, 1, 1, 1};
        int res = sl.sumOfUnique(nums);

        System.out.println(res);
    }
}

class Solution {
    public int sumOfUnique(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();

        Arrays.stream(nums).forEach(x -> m.put(x, m.getOrDefault(x, 0) + 1));

        return m.entrySet().stream().filter(x -> x.getValue() == 1)
                .map(Map.Entry::getKey)
                .reduce(Integer::sum)
                .orElse(0);
    }
}