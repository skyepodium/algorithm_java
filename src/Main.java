import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int max_val = 2147483647;
    static int n, m, oil, a[][], start_x, start_y, person_x, person_y, target_x, target_y, person_dist, target_dist, person_cnt, check[][];
    static Info target[][];
    static int dx[] = {0, 0, 1, -1}, dy[] = {-1, 1, 0, 0};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        oil = Integer.parseInt(st.nextToken());

        a = new int[n+1][n+1];
        target = new Info[n+1][n+1];
        check = new int[n+1][n+1];

        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        start_x = Integer.parseInt(st.nextToken());
        start_y = Integer.parseInt(st.nextToken());

        for(int i=1; i<=m; i++) {
            st = new StringTokenizer(br.readLine());

            person_x = Integer.parseInt(st.nextToken());
            person_y = Integer.parseInt(st.nextToken());
            target_x = Integer.parseInt(st.nextToken());
            target_y = Integer.parseInt(st.nextToken());

            a[person_x][person_y] = -1;

            target[person_x][person_y] = new Info(target_x, target_y);
        }

        person_cnt = m;

        while(person_cnt > 0) {

            init();

            person_bfs();

            if(oil <= person_dist) break;

            oil -= person_dist;

            a[person_x][person_y] = 0;

            Info target_info = target[person_x][person_y];
            target_x = target_info.x;
            target_y = target_info.y;

            init();

            target_bfs();

            if(oil < target_dist) break;

            oil += target_dist;

            person_cnt--;

            start_x = target_x;
            start_y = target_y;
        }

        if(person_cnt > 0) oil = -1;

        System.out.println(oil);
    }

    public static void init() {
        person_dist = target_dist = max_val;
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                check[i][j] = -1;
            }
        }
    }

    public static void person_bfs() {
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(start_x, start_y));
        check[start_x][start_y] = 0;

        if(a[start_x][start_y] == -1) {
            person_x = start_x;
            person_y = start_y;
            person_dist = check[start_x][start_y];
        }

        while(!q.isEmpty()) {
            Info cur = q.poll();
            int x = cur.x;
            int y = cur.y;

            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx > n || nx < 1 || ny > n || ny < 1) continue;

                if(a[nx][ny] != 1 && check[nx][ny] == -1) {
                    check[nx][ny] = check[x][y] + 1;

                    if(a[nx][ny] == -1) {
                        if(check[nx][ny] == person_dist) {
                            if(nx == person_x) {
                                if(ny < person_y) {
                                    person_dist = check[nx][ny];
                                    person_x = nx;
                                    person_y = ny;
                                }
                            }
                            else if(nx < person_x){
                                person_dist = check[nx][ny];
                                person_x = nx;
                                person_y = ny;
                            }
                        }
                        else if(check[nx][ny] < person_dist){
                            person_dist = check[nx][ny];
                            person_x = nx;
                            person_y = ny;
                        }
                    }
                    q.add(new Info(nx, ny));
                }
            }
        }
    }

    public static void target_bfs() {
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(person_x, person_y));
        check[person_x][person_y] = 0;

        while(!q.isEmpty()) {
            Info cur = q.poll();
            int x = cur.x;
            int y = cur.y;

            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx > n || nx < 1 || ny > n || ny < 1) continue;

                if(a[nx][ny] != 1 && check[nx][ny] == -1) {
                    check[nx][ny] = check[x][y] + 1;

                    if(nx == target_x && ny == target_y) {
                        target_dist = check[nx][ny];
                    }

                    q.add(new Info(nx, ny));
                }
            }
        }
    }

    public static class Info {
        int x, y;

        public Info(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}