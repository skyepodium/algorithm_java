class Solution {
    int[] dx = {0, 0, 1, 1};
    int[] dy = {0, 1, 0, 1};
    String[][] b;
    boolean[][] check;
    public int solution(int m, int n, String[] board) {
        // 1. init
        int res = 0;
        int temp = n;
        n = m;
        m = temp;
        b = new String[n][m];
        check = new boolean[n][m];
        for(int i=0; i<n; i++) {
            String[] t = board[i].split("");
            for(int j=0; j<m; j++) {
                b[i][j] = t[j];
            }
        }

        while(true) {
            // 1) init
            init(n, m);

            // 2) search
            int searchCnt = search(n, m);
            if(searchCnt == 0) break;
            res += searchCnt;

            // 3) clear
            clear(n, m);

            // 4) move
            move(n, m);
        }

        return res;
    }

    public void init(int n, int m) {
        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++)
                check[i][j] = false;
    }

    public int search(int n, int m) {
        int cnt = 0;

        for(int i=0; i<n-1; i++) {
            for(int j=0; j<m-1; j++) {
                String prev = b[i][j];
                if(prev.equals("")) continue;

                boolean isSame = true;
                for(int k=0; k<4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    String cur = b[nx][ny];
                    if(!prev.equals(cur)) {
                        isSame = false;
                        break;
                    }
                }

                if(!isSame) continue;

                for(int k=0; k<4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if(check[nx][ny]) continue;
                    check[nx][ny] = true;
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public void move(int n, int m) {
        for(int j=0; j<m; j++) {
            for(int idx=n-1; idx>=0; idx--) {
                int i = idx;
                if(b[i][j].equals("") || check[i][j]) continue;

                while(i < n-1 && !b[i][j].equals("") && b[i+1][j].equals("")) {
                    b[i+1][j] = b[i][j];
                    b[i][j] = "";
                    i++;
                }
            }
        }
    }

    public void clear(int n, int m) {
        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++)
                if(check[i][j]) b[i][j] = "";
    }
}

public class Main {
    public static void main(String[] args) {
        int m = 4;
        int n = 5;
        String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};

        Solution sl = new Solution();

        int res = sl.solution(m, n, board);

        System.out.println("res " + res);
    }
}