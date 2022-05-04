class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        // 1. init
        int n = coordinates.length;

        // 2. loop
        for(int i=0; i<n-2; i++) {
            if(ccw(new Point(coordinates[i][0], coordinates[i][1]), new Point(coordinates[i+1][0], coordinates[i+1][1]), new Point(coordinates[i+2][0], coordinates[i+2][1])) != 0) return false;
        }

        return true;
    }

    public int ccw(Point p, Point q, Point r) {
        long first = (p.x - r.x) * (q.y - r.y);
        long second = (p.y - r.y) * (q.x - r.x);
        long result = first - second;

        if(result > 0) return 1;
        else if(result == 0) return 0;
        else return -1;
    }
}

class Point {
    long x, y;
    public Point(long x, long y) {
        this.x = x;
        this.y = y;
    }
}