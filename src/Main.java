import java.util.*;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        Solution sl = new Solution();

        String s = "abcdefghi";
        int k = 3;
        char fill = 'x';


//        String s = "abcdefghij";
//        int k = 3;
//        char fill = 'x';

        String[] res = sl.divideString(s, k, fill);

        for(String a: res) {
            System.out.println(a);
        }
    }
}

class Solution {
    public String[] divideString(String s, int k, char fill) {
        // 1. init
        List<String> res = new ArrayList<>();
        int n = s.length();
        int cnt = n % k != 0 ? n / k + 1 : n / k;

        StringBuilder base = new StringBuilder();
        for(int i=0; i<k; i++) base.append(fill);
        String b = base.toString();

        // 2. loop
        for(int i=0; i<n; i+=k) {
            res.add(s.substring(i, Math.min(i+k, n)));
        }

        // 3. map
        return res.stream().map(x -> x.length() < k ? x + b.substring(0, k - x.length()) : x)
                .collect(Collectors.toList())
                .toArray(new String[cnt]);
    }
}