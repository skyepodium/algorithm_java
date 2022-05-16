import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        // 1. init
        int n = grid.length;
        int m = grid[0].length;

        return bfs(0, 0, grid, n, m);
    }

    public int bfs(int x, int y, int[][] grid, int n, int m) {
        // 1) init
        int[][] check = new int[n][m];
        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++)
                check[i][j] = -1;

        int[][] d = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};


        // 2) bfs
        Queue<Point> q = new LinkedList<>();
        if(grid[x][y] == 0) {
            q.add(new Point(x, y));
            check[x][y] = 1;
        }

        while(!q.isEmpty()) {
            Point cur = q.poll();
            x = cur.x;
            y = cur.y;

            for(int[] dd: d) {
                int nx = x + dd[0];
                int ny = y + dd[1];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(grid[nx][ny] != 0 || check[nx][ny] != -1) continue;

                check[nx][ny] = check[x][y] + 1;
                q.add(new Point(nx, ny));
            }
        }

        return check[n-1][m-1];
    }
}

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}