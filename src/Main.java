public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();

        s.lengthOfLastWord(" ");
    }
}

class Solution {
    public int lengthOfLastWord(String s) {

        String res[] = s.split(" ");

        int size = res.length;

        if(size - 1 < 0) return 0;

        return res[res.length-1].length();
    }
}