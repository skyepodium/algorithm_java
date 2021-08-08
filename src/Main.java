class Main {
    public static void main(String[] args) {
        Solution sl = new Solution();

        String s = "babad";
        String res = sl.longestPalindrome(s);

        System.out.println(res);
    }
}

class Solution {
    public String longestPalindrome(String s) {

        String result = "";
        int size = s.length();

        // 1. 에외 처리
        if(size < 2 || s.equals(reverString(s))) return s;

        // 2. 중심점 하나씩 탐색
        for(int i=0; i<=size-1; i++) {
            result = maxString3(result,
                    // 3. 투 포인터 확장
                    expand(i, i+1, s),
                    expand(i, i+2, s)
            );
        }

        return result;
    }

    public String expand(int l, int r, String s) {

        while (l >= 0 && r <= s.length() && s.charAt(l) == s.charAt(r-1)) {
            l--;
            r++;
        }
        return s.substring(l+1, r-1);
    }

    public String maxString(String a, String b) {
        return a.length() > b.length() ? a : b;
    }

    public String maxString3(String a, String b, String c) {
        return maxString(maxString(a, b), c);
    }

    public String reverString(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
}