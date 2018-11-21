import java.util.*;


public class Main {

    static int t, n, m, k, a, b;
    static int[][] d;
    static boolean[][] check;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {-1, 1, 0, 0};


    public static void dfs(int x, int y){
        check[x][y] = true;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && nx<n && ny>=0 && ny<m){
                if(check[nx][ny] == false && d[nx][ny] == 1){
                    dfs(nx, ny);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        t = sc.nextInt();
        for(int test_case=0; test_case<t; test_case++){

            m = sc.nextInt();
            n = sc.nextInt();
            k = sc.nextInt();

            d = new int[n+1][m+1];
            check = new boolean[n+1][m+1];

            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    d[i][j] = 0;
                    check[i][j] = false;
                }
            }

            for(int i=0; i<k; i++){
                b = sc.nextInt();
                a = sc.nextInt();
                d[a][b] = 1;
            }

            int cnt = 0;
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(check[i][j] == false && d[i][j] == 1){
                        dfs(i, j);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);

        }

    }
}
