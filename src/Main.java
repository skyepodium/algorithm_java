class Solution {

    public int[][] check;
    public char[][] a;
    public int n, m, cnt;
    public int[] dx = {0, 0, 1, -1};
    public int[] dy = {-1, 1, 0, 0};

    public int numIslands(char[][] grid) {

        n = grid.length;
        m = grid[0].length;

        check = new int[n][m];

        a = grid;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == '1' && check[i][j] == 0) {
                    dfs(i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public void dfs(int x, int y) {
        check[x][y] = 1;

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

            if(a[nx][ny] == '1' && check[nx][ny] == 0) {
                dfs(nx, ny);
            }
        }
    }
}