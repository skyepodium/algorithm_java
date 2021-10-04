import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {-1, 1, 0, 0};
    public static int n, m;
    public static int res = 0;
    public static boolean[][] check;
    public int islandPerimeter(int[][] grid) {
        // 1. init
        res = 0;
        n = grid.length;
        m = grid[0].length;
        check = new boolean[n][m];

        // 2. loop
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 1 && !check[i][j]) {
                    res += bfs(i, j, grid);
                }
            }
        }

        return res;
    }

    public int bfs(int x, int y, int[][] grid) {
        int cnt = 0;
        int linkCnt = 0;

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(x, y));
        check[x][y] = true;

        while(!q.isEmpty()) {
            Info cur = q.poll();
            cnt++;
            x = cur.x;
            y = cur.y;

            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                if(grid[nx][ny] == 1) {
                    linkCnt++;
                    if(!check[nx][ny]) {
                        check[nx][ny] = true;
                        q.add(new Info(nx, ny));
                    }
                }
            }
        }

        return cnt * 4 - linkCnt;
    }
}

class Info {
    int x;
    int y;

    public Info(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Main {
    public static void main(String[] args) {
        Solution sl = new Solution();
        int[][] grid ={{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
//        int[][] grid = {{1}};
        int res = sl.islandPerimeter(grid);

        System.out.println(res);
    }
}