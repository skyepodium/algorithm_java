public class Main {

    public static void main(String[] args) {

    }
}

class Solution {
    public void reverseString(char[] s) {
        int size = s.length;

        int l = 0;
        int r = size - 1;

        while (l < r) {
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;

            l++;
            r--;
        }
    }
}