import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    int n, m;
    int[][] d;
    int[][] dir = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
    public int minimumEffortPath(int[][] heights) {
        // 1. init
        int maxVal = 1000000;
        n = heights.length;
        m = heights[0].length;
        d = new int[n][m];
        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++)
                d[i][j] = maxVal;

        // 2. dijkstra
        dijkstra(0, 0, heights);

        return d[n-1][m-1];
    }

    public void dijkstra(int startX, int startY, int[][] heights) {
        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        d[startX][startY] = 0;
        pq.add(new Point(startX, startY, 0));

        while(!pq.isEmpty()) {
            Point cur = pq.poll();
            int x = cur.x;
            int y = cur.y;
            int cost = cur.cost;

            if(d[x][y] < cost) continue;

            for(int[] da: dir) {
                int nx = x + da[0];
                int ny = y + da[1];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                int nCost = Math.max(Math.abs(heights[nx][ny] - heights[x][y]), d[x][y]);

                if(d[nx][ny] > nCost) {
                    d[nx][ny] = nCost;
                    pq.add(new Point(nx, ny, d[nx][ny]));
                }
            }
        }
    }
}

class Point {
    int x, y, cost;
    public Point(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
}