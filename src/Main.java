class Solution {
    public String digitSum(String s, int k) {
        while(s.length() > k) {
            String base = "";

            for(int i=0; i<s.length(); i+=k) {
                base += sumStr(s.substring(i, Math.min(i+k, s.length())));
            }

            s = base;
        }

        return s;
    }

    public String sumStr(String s) {
        int res = 0;

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            res += (int)c - (int)'0';
        }

        return Integer.toString(res);
    }
}