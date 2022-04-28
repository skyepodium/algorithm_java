import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    int[][][] d;
    int[] dx = {0, 0, 1, -1};
    int[] dy = {-1, 1, 0, 0};

    public int solution(int[][] board) {
        // 1. init
        int n = board.length;
        int m = board[0].length;
        int maxVal = n * m * 600;
        d = new int[n][m][4];
        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++)
                for(int k=0; k<4; k++)
                    d[i][j][k] = maxVal;

        dijkstra(0, 0, n, m, board);

        return Arrays.stream(d[n - 1][m - 1]).min().orElse(0);
    }

    public void dijkstra(int startX, int startY, int n, int m, int[][] board) {
        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));

        for(int i=0; i<4; i++) {
            d[startX][startY][i] = 0;
            pq.add(new Info(startX, startY, 0, i));
        }

        while(!pq.isEmpty()) {
            Info cur = pq.poll();
            int x = cur.x;
            int y = cur.y;
            int dir = cur.dir;

            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= n || ny < 0 || ny >=m) continue;
                if(board[nx][ny] == 1) continue;

                int nCost = dir == i ? 100 : 600;

                if(d[nx][ny][i] > d[x][y][dir] + nCost) {
                    d[nx][ny][i] = d[x][y][dir] + nCost;
                    pq.add(new Info(nx, ny, nCost, i));
                }
            }
        }
    }
}

class Info {
    int x, y, cost, dir;
    public Info(int x, int y, int cost, int dir) {
        this.x = x;
        this.y = y;
        this.cost = cost;
        this.dir = dir;
    }
}

class Main {
    public static void main(String[] args) {

        Solution sl = new Solution();
        int[][] board = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        int res = sl.solution(board);

        System.out.println("res " + res);
    }
}