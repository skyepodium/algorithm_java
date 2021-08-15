import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{

    public static int n, m, startNode, a, b, c;
    public static int max_val = Integer.MAX_VALUE;
    public static List<Info>[] v;
    public static int[] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        d = new int[n+1];
        v = new ArrayList[n+1];

        for(int i=0; i<=n; i++) {
            d[i] = max_val;
            v[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        startNode = Integer.parseInt(st.nextToken());

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            v[a].add(new Info(b, c));
        }

        dijkstra(startNode);

        for(int i=1; i<=n; i++) {
            if(d[i] == max_val) System.out.println("INF");
            else System.out.println(d[i]);
        }
    }

    public static void dijkstra(int startNode) {
        d[startNode] = 0;
        PriorityQueue<Info> pq = new PriorityQueue<>(new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                return o1.cost - o2.cost;
            }
        });
        pq.add(new Info(startNode, d[startNode]));

        while(!pq.isEmpty()) {
            Info cur = pq.poll();
            int node = cur.node;
            int cost = cur.cost;

            if(d[node] < cost) continue;

            for(Info next: v[node]) {
                int n_node = next.node;
                int n_cost = next.cost;

                if(d[n_node] > d[node] + n_cost) {
                    d[n_node] = d[node] + n_cost;
                    pq.add(new Info(n_node, d[n_node]));
                }
            }
        }
    }
}

class Info {
    int node, cost;
    public Info(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
}