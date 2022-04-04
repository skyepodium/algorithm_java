import java.util.LinkedList;
import java.util.List;

class Main {
    public static void main(String[] args) {

        List<Integer> a = new LinkedList<>();

        a.remove(3);
    }
}

class Solution {
    public String freqAlphabets(String s) {

        for(int i=26; i>=0; i--) {
            String pattern = i >= 10 ? i + "#" : i + "";
            s = s.replaceAll(pattern, getAlphabet(i));
        }

        return s;
    }

    public String getAlphabet(int n) {
        return (char)((int)'a' + n - 1) + "";
    }
}