public class Main {

    public static void main(String[] args) {

    }
}

class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        s = s.toLowerCase();

        int size = s.length();
        for(int i=0; i<size/2; i++) {
            if(s.charAt(i) != s.charAt(size - i - 1)) {
                return false;
            }
        }

        return true;
    }
}