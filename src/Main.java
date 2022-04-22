class Solution {
    public String solution(int n, int t, int m, int p) {
        String r = "";
        for(int i=0; i<t*m; i++) {
            r += intToBaseStr(i, n);
        }

        String res = "";
        for(int i=p; i<=t*m; i+=m) {
            res += r.charAt(i-1);
        }

        return res;
    }

    public String intToBaseStr(int num, int base) {
        String res = "";

        while(num > 0) {
            int remain = num % base;

            if(remain >= 10) res += (char)((int)'A' + remain % 10);
            else res += Integer.toString(remain);

            num /= base;
        }

        if(res.equals("")) res = "0";

        return new StringBuilder(res).reverse().toString();
    }
}