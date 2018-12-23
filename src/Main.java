import java.util.*;


public class Main {

    static int t, n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();

        for(int test_case = 1; test_case <= t; test_case++){
            float total = 0;
            float a;
            int b;
            n = sc.nextInt();
            for(int i=0; i<n; i++){
                a = sc.nextFloat();
                b = sc.nextInt();
                total += (a*b);
            }
            System.out.println("#" + test_case + " " + total);
        }

    }


}
