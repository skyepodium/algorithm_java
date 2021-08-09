import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Main {
    public static void main(String[] args) {
        Solution sl = new Solution();

        int[] nums = {1, 2, 3};

        List<List<Integer>> res = sl.permute(nums);

        for(List<Integer> cur: res) {
            for(int num: cur) {
                System.out.print(num);
            }
            System.out.println();
        }
    }
}

class Solution {

    int size = 0;
    int[] check;
    int[] curNums;
    List<List<Integer>> result;
    public List<List<Integer>> permute(int[] nums) {

        size = nums.length;
        check = new int[21];
        curNums = nums;

        result = new ArrayList<>();

        go(0, new ArrayList<>());

        System.out.println(result.get(0));
        return result;
    }

    public void go(int idx, ArrayList<Integer> stack) {
        if(idx >= size) {
            result.add(new ArrayList<>(stack));
            return;
        }

        for(int num: curNums) {
            if(check[num + 10] == 0) {
                check[num+10] = 1;
                stack.add(num);

                go(idx + 1, stack);

                check[num+10] = 0;
                stack.remove(stack.size() - 1);
            }
        }
    }
}