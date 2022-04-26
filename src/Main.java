import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {
    int[] d;
    public int minCostConnectPoints(int[][] points) {
        // 1. init
        int n = points.length;
        d = new int[n];
        for(int i=0; i<n; i++) d[i] = i;
        List<Point> l = new ArrayList<>();
        int res = 0;

        // 2. make graph
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                int dist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                l.add(new Point(i, j, dist));
            }
        }

        // 3. sort
        l.sort(Comparator.comparingInt(a -> a.cost));

        // 4. cost
        for(Point p: l) {
            int s = find(p.start);
            int e = find(p.end);
            int c = p.cost;

            if(s != e) {
                d[s] = e;
                res += c;
            }
        }

        return res;
    }

    public int find(int node) {
        if(node == d[node]) return node;
        else return d[node] = find(d[node]);
    }
}

class Point {
    int start;
    int end;
    int cost;
    public Point(int start, int end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }
}