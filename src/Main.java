import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Solution {

    public int n, m;
    public boolean [][]check;
    public char [][]b;
    public int []dx = {0, 0, 1, -1};
    public int []dy = {-1, 1, 0, 0};
    public Stack<Position> s;
    public void solve(char[][] board) {
        // 1. init
        b = board;
        n = board.length;
        m = board[0].length;
        check = new boolean[n+1][m+1];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                check[i][j] = false;
            }
        }
        s = new Stack<>();

        // 2. loop
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(!check[i][j] && b[i][j] == 'O') {
                    boolean isAdjacentToBorder = bfs(i, j);
                    if(!isAdjacentToBorder)
                        flip();
                    else
                        s.clear();
                }
            }
        }

    }

    public void flip(){
        for(Position p: s) {
            b[p.x][p.y] = 'X';
        }
    }

    public boolean bfs(int x, int y) {
        Queue<Position> q = new LinkedList<>();
        check[x][y] = true;
        q.add(new Position(x, y));
        boolean isAdjacentToBorder = false;

        while(!q.isEmpty()) {
            Position p = q.poll();
            s.add(p);
            x = p.x;
            y = p.y;
            if(x == 0 || x == n-1 || y == 0 || y == m-1) {
                isAdjacentToBorder = true;
            }

            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                if(!check[nx][ny] && 'O' == b[nx][ny]) {
                    check[nx][ny] = true;
                    q.add(new Position(nx, ny));
                }
            }

        }

        return isAdjacentToBorder;
    }
}

class Position {
    int x, y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
