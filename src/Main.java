class Solution {
    public int countSubstrings(String s) {
        // 1. init
        int n = s.length();
        int res = 0;

        // 2. loop
        for(int i=0; i<n; i++) {
            res += isPalindrome(i, i, n, s);
            res += isPalindrome(i, i+1, n, s);
        }

        return res;
    }

    public int isPalindrome(int l, int r, int n, String s) {
        int res = 0;

        while(l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
            res++;
            l--;
            r++;
        }

        return res;
    }
}