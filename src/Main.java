import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int n, idx, res = 0;
    int[][] check;
    int[] dx = {0, 0, 1, -1};
    int[] dy = {-1, 1, 0, 0};
    HashMap<Integer, Integer> m = new HashMap<>();
    public int largestIsland(int[][] grid) {
        // 1. init
        n = grid.length;
        check = new int[n+1][n+1];

        // 2. loop
        idx = 1;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1 && check[i][j] == 0) {
                    int curCnt = bfs(i, j, idx, grid);
                    m.put(idx, curCnt);
                    idx++;
                }
            }
        }

        // 3. loop
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 0) {

                    int sumCnt = 0;
                    HashSet<Integer> s = new HashSet<>();
                    for(int k = 0; k<4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if(nx < 0 || nx >= n || ny < 0 || ny >= n) {
                            continue;
                        }

                        if(check[nx][ny] > 0 && !s.contains(check[nx][ny])){
                            int nIdx = check[nx][ny];
                            int curCnt = m.get(nIdx);
                            sumCnt += curCnt;
                            s.add(nIdx);
                        }
                    }
                    res = Math.max(res, sumCnt + 1);
                }
            }
        }

        return res > 0 ? res : n*n;
    }

    public int bfs(int startX, int startY, int idx, int[][] grid) {
        int cnt = 0;
        check[startX][startY] = idx;
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(startX, startY));

        while(!q.isEmpty()) {
            Info cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            cnt++;

            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }

                if(grid[nx][ny] == 1 && check[nx][ny] == 0) {
                    check[nx][ny] = idx;
                    q.add(new Info(nx, ny));
                }
            }
        }
        return cnt;
    }
}

class Info {
    int x, y;
    public Info(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Main{
    public static void main(String[] args) {
        int[][] grid = {{1,0},{0,1}};

        Solution sl = new Solution();
        int res = sl.largestIsland(grid);

        System.out.println(res);
    }
}