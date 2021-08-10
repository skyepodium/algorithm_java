import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) {
        Solution sl = new Solution();
        int[] c = {1, 2, 3,};

        List<List<Integer>> result = sl.subsets(c);

        for(List<Integer> nums: result) {
            for(int num: nums) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

    }
}

class Solution {

    int[] numsArr;
    int size;
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {

        numsArr = nums;
        size = nums.length;

        go(0, new ArrayList<>());

        return result;
    }

    public void go(int idx, List<Integer> stack) {
        result.add(new ArrayList<>(stack));

        for(int i=idx; i<size; i++) {
            stack.add(numsArr[i]);
            go(i + 1, stack);
            stack.remove(stack.size() - 1);
        }
    }
}