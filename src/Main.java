import javax.swing.*;

class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int titleToNumber(String columnTitle) {
        // 1. init
        int result = 0;

        // 2. loop
        for(int i=0; i<columnTitle.length(); i++) {
            char c = columnTitle.charAt(i);
            result = result * 26 + (int)c - (int)'A' + 1;
        }

        return result;
    }
}