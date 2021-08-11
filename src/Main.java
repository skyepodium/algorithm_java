import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int n, m, a, b, c, startNode, endNode;
    static ArrayList<Info>[] v;
    static int[] d;
    static int maxVal = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());

        d = new int[n+1];

        v = new ArrayList[n+1];
        for(int i=0; i<=n; i++) {
            v[i] = new ArrayList<>();
            d[i] = maxVal;
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            v[a].add(new Info(b, c));
        }

        st = new StringTokenizer(br.readLine());
        startNode = Integer.parseInt(st.nextToken());
        endNode = Integer.parseInt(st.nextToken());

        dijkstra(startNode);

        System.out.println(d[endNode]);

    }

    public static void dijkstra(int node) {
        d[node] = 0;
        PriorityQueue<Info> pq = new PriorityQueue<>(new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                return o1.cost - o2.cost;
            }
        });
        pq.add(new Info(node, d[node]));

        while(!pq.isEmpty()) {
            Info cur = pq.poll();

            int cNode = cur.node;
            int cCost = cur.cost;

            if(d[cNode] < cCost) continue;

            for(Info nInfo: v[cNode]) {
                int nNode = nInfo.node;
                int nCost = nInfo.cost;

                if(d[nNode] > d[cNode] + nCost) {
                    d[nNode] = d[cNode] + nCost;
                    pq.add(new Info(nNode, d[nNode]));
                }
            }
        }
    }
}

class Info {
    int node;
    int cost;

    Info(int node, int cost){
        this.node = node;
        this.cost = cost;
    }
}