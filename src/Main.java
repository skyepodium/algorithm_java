import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    List<List<Integer>> permutation = new ArrayList<>();
    boolean[] check;
    int n;
    public int solution(int k, int[][] dungeons) {
        // 1. init
        int res = 0;
        n = dungeons.length;
        check = new boolean[n];

        dfs(0, new Stack<>());

        // 3. loop
        for(List<Integer> p: permutation) {
            int life = k;
            int cnt = 0;
            for(int idx: p) {
                int[] d = dungeons[idx];
                int a = d[0];
                int b = d[1];
                if(life < a || life < b) break;
                life -= b;
                cnt++;
            }
            res = Math.max(res, cnt);
        }

        return res;
    }

    public void dfs(int cnt, Stack<Integer> l) {
        if(cnt >= n) {
            permutation.add(new ArrayList<>(l));
            return;
        }

        for(int i=0; i<n; i++) {
            if(!check[i]) {
                check[i] = true;
                l.add(i);
                dfs(cnt + 1, l);
                check[i] = false;
                l.pop();
            }
        }
    }
}