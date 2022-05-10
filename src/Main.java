import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    boolean[] check = new boolean[10];
    public List<List<Integer>> combinationSum3(int k, int n) {

        go(0, new Stack<>(), 0, n, k);

        return res;
    }

    public void go(int cnt, Stack<Integer> s, int sumVal, int n, int k) {
        if(sumVal > n) return;

        if(cnt >= k) {
            if(sumVal == n)
                res.add(new ArrayList<>(s));
            return;
        }

        for(int i=1; i<10; i++) {
            if(!check[i]) {
                if(!s.isEmpty() && s.peek() > i) continue;

                check[i] = true;
                s.add(i);
                go(cnt + 1, s, sumVal + i, n, k);
                check[i] = false;
                s.pop();
            }
        }
    }
}