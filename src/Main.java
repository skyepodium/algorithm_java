import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) {
        Solution sl = new Solution();

//        int[] c = {2, 3, 6, 7};
//        int target = 7;

//        int[] c = {2};
//        int target = 1;
        int[] c = {2, 3, 5};
        int target = 8;


        List<List<Integer>> result = sl.combinationSum(c, target);

        for(List<Integer> nums: result) {
            for(int num: nums) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

    }
}

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int targetVal = 0;
    int[] cData;
    int size = 0;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        targetVal = target;
        cData = candidates;
        size = candidates.length;

        go(0, 0, new ArrayList<>());

        return result;
    }

    public void go(int idx, int sumVal, List<Integer> stack) {
        if(sumVal >= targetVal) {
            if(sumVal == targetVal) {
                result.add(new ArrayList<>(stack));
            }
            return;
        }

        for(int i=idx; i<size; i++) {
            stack.add(cData[i]);
            go(i, sumVal + cData[i], stack);
            stack.remove(stack.size() - 1);
        }
    }
}