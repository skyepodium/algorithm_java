import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {

    int maxVal = 1000001;
    int res = maxVal;
    int[][] d;
    ArrayList<Node>[] v;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // 1. init
        d = new int[n+1][k+2];
        v = new ArrayList[n+1];
        for(int i=0; i<=n; i++) {
            for(int j=0; j<=k+1; j++) {
                d[i][j] = maxVal;
            }
            v[i] = new ArrayList<>();
        }

        // 2. make_graph
        for(int[] flight: flights) {
            int s = flight[0];
            int e = flight[1];
            int c = flight[2];
            v[s].add(new Node(e, c, 0));
        }

        // 3. dijkstra
        dijkstra(src, k);

        // 4. check loop
        for(int i=0; i<=k+1; i++) {
            res = Math.min(res, d[dst][i]);
        }

        return res == maxVal ? -1 : res;
    }

    public void dijkstra(int startNode, int k) {
        d[startNode][0] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.cost - o2.cost;
            }
        });
        pq.add(new Node(startNode, d[startNode][0], 0));

        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            int node = cur.node;
            int cost = cur.cost;
            int cnt = cur.cnt;

            if(d[node][cnt] < cost) continue;

            for(Node next: v[node]) {
                int n_node = next.node;
                int n_cost = next.cost;

                if(cnt + 1 <= k+1 && d[n_node][cnt+1] > d[node][cnt] + n_cost) {
                    d[n_node][cnt+1] = d[node][cnt] + n_cost;
                    pq.add(new Node(n_node, d[n_node][cnt+1], cnt+1));
                }
            }
        }
    }
}

class Node {
    int node, cost, cnt;

    public Node(int node, int cost, int cnt) {
        this.node = node;
        this.cost = cost;
        this.cnt = cnt;
    }
}