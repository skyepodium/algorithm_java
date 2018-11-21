import java.util.Scanner;

public class Solution {
    public static int t, n;
    public static int[][] d = new int[50][50];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        t = sc.nextInt();

        for(int test_case = 1; test_case <=t; test_case++){

            n = sc.nextInt();

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    d[i][j] = sc.nextInt();
                }
            }


            System.out.println("#" + test_case + " ");

        }
    }
}
