import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Main {
    public static void main(String[] args) {
//        String numbers = "17";
        String numbers = "011";

        Solution sl = new Solution();

        int res = sl.solution(numbers);

        System.out.println("res " + res);

    }
}

class Solution {
    int size;
    boolean[] d, check, used;
    Integer[] nums;
    ArrayList<Integer> stack = new ArrayList<>();
    int cnt = 0;
    public int solution(String numbers) {
        // 1. init
        size = numbers.length();

        nums = new Integer[size];
        for(int i=0; i<size; i++) {
            nums[i] = Integer.parseInt(String.valueOf(numbers.charAt(i)));
        }
        Arrays.sort(nums, Collections.reverseOrder());

        int maxInt = 0;
        for(int num: nums){
            maxInt = maxInt * 10 + num;
        }
        d = new boolean[maxInt + 1];
        used = new boolean[maxInt + 1];

        // 2. eratos
        eratos(maxInt);

        int answer = 0;

        check = new boolean[size];
        dfs(0);

        return cnt;
    }

    public void dfs(int idx) {
        if(stack.size() >= 1 && !(stack.size() >= 2 && stack.get(0) == 0)) {
            Integer val = stack.stream().reduce(0, (a, b) -> {
                return a * 10 + b;
            });

            if(val >= 2 && !used[val] && !d[val]) {
                used[val] = true;
                cnt++;
            }
        }

        if(idx == size) {
            return;
        }

        for(int i=0; i<size; i++) {
            if(!check[i]) {
                check[i] = true;
                stack.add(nums[i]);
                dfs(idx + 1);
                check[i] = false;
                stack.remove(stack.size()-1);
            }
        }
    }

    public void eratos(int n) {
        for(int i=2; i*i<=n; i++) {
            for(int j=i+i; j<=n; j=j+i) {
                if(!d[j]) d[j] = true;
            }
        }
    }
}