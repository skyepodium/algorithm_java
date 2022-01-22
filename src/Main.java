class Solution {
    public boolean isPalindrome(String s) {
        // 1. replace
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");

        // 2. two pointer - loop
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

class Main {
    public static void main(String[] args) {

    }
}