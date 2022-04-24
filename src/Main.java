import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    public int solution(int n, int k) {
        // 1. init
        int res = 0;

        String num = intToBase(n, k);

        if(num.equals(num.replaceAll("0", "")) && isPrime(Long.parseLong(num))) res++;

        String[] regex_list = {"^([1-9]+)0", "0([1-9]+)$", "(?=0([1-9]+)0)"};

        for(String regex: regex_list) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(num);
            while(matcher.find()) {
                if(isPrime(Long.parseLong(matcher.group(1)))) res++;
            }
        }

        return res;
    }

    public String intToBase(int n, int k) {
        StringBuilder r = new StringBuilder();

        while(n > 0) {
            r.append(n % k);
            n /= k;
        }

        return r.reverse().toString();
    }

    public boolean isPrime(long val) {
        if(val < 2) return false;

        int mid = (int) Math.sqrt(val);

        for(int i=2; i<=mid; i++) {
            if(val % i == 0) return false;
        }

        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution sl = new Solution();

       int n = 437674;
       int k = 3;

//       int n = 110011;
//       int k = 10;

       int res = sl.solution(n, k);

        System.out.println("res " + res);
    }
}