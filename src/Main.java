import java.util.*;


public class Main {

    static String a, b, c, d;
    static long first, second;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.next();
        b = sc.next();
        c = sc.next();
        d = sc.next();

        a = a + b;
        c = c + d;
        first = sToInt(a);
        second = sToInt(c);
        System.out.println(first + second);
    }

    public static long sToInt(String s){
        long result = 0;
        for(int i=s.length() - 1; i>=0; i--){
            result += (s.charAt(i) - '0') * Math.pow(10, s.length() -1 - i);
        }
        return result;
    }

}
