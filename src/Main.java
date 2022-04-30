import java.util.*;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    boolean[] check;
    int n;
    Set<String> s = new HashSet<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        n = nums.length;
        check = new boolean[n];

        dfs(new Stack<>(), 0, nums);

        return res;
    }

    public void dfs(Stack<Integer> l, int cnt, int[] nums) {
        if(cnt >= n) {
            List<Integer> cur = new ArrayList<>(l);
            StringBuilder key = new StringBuilder();
            for(int i=0; i<cur.size(); i++) {
                key.append(cur.get(i).toString());
            }
            if(!s.contains(key.toString())) {
                s.add(key.toString());
                res.add(cur);
            }
            return;
        }

        for(int i=0; i<n; i++) {
            if(!check[i]) {
                check[i] = true;
                l.push(nums[i]);
                dfs(l, cnt + 1, nums);
                l.pop();
                check[i] = false;
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        Solution sl = new Solution();
        int[] nums = {1,1,2};

        sl.permuteUnique(nums);
    }
}