import java.util.Locale;

class Main {
    public static void main(String[] args) {
        Solution sl = new Solution();
    }
}

class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int l = 0;
        int r = s.length() - 1;

        while(l < r) {
            if(s.charAt(l) != s.charAt(r)) return false;

            l++;
            r--;
        }

        return true;
    }
}