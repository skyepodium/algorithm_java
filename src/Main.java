import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int n, m, start_node, s, e;
    public static boolean check[];
    public static ArrayList<Integer> v[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        start_node = Integer.parseInt(st.nextToken());

        check = new boolean[n+1];
        v = new ArrayList[n+1];
        for(int i=0; i<=n; i++) {
            v[i] = new ArrayList<>();
        }

        for(int i=1; i<=m; i++) {
            st = new StringTokenizer(br.readLine());

            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            v[s].add(e);
            v[e].add(s);
        }

        for(int i=1; i<=n; i++) {
            Collections.sort(v[i]);
        }

        dfs(start_node);
        System.out.println();
        check = new boolean[n+1];
        bfs(start_node);
        System.out.println();
    }

    public static void dfs(int node) {
        check[node] = true;
        System.out.print(node + " ");

        for(int next_node: v[node]) {
            if(!check[next_node]) {
                dfs(next_node);
            }
        }
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        check[start] = true;
        q.add(start);

        while(!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node + " ");

            for(int next_node: v[node]) {
                if(!check[next_node]) {
                    check[next_node] = true;
                    q.add(next_node);
                }
            }
        }
    }
}