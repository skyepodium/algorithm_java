import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Main {
    public static void main(String[] args) {
        Solution sl = new Solution();

        int n = 4;
        int k = 2;

        List<List<Integer>> res = sl.combine(n, k);

        for(List<Integer> nums: res) {
            for(int num: nums) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

class Solution {

    List<List<Integer>> result = new ArrayList<>();
    int nVal = 0;
    public List<List<Integer>> combine(int n, int k) {

        nVal = n;

        go(0, k, new ArrayList<>());

        return result;
    }

    public void go(int idx, int remain, ArrayList<Integer> stack) {
        if(remain == 0) {
            result.add(new ArrayList<>(stack));
            return;
        }

        for(int i=idx; i< nVal; i++) {
            stack.add(i + 1);
            go(i + 1, remain - 1, stack);
            stack.remove(stack.size() - 1);
        }
    }
}