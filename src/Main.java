import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) {
        Solution sl = new Solution();

        String digits = "23";

        List<String> res = sl.letterCombinations(digits);

        for(String num: res) {
            System.out.println(num);
        }

    }
}

class Solution {

    int size = 0;
    List<String> result = new ArrayList<>();
    String[] nums = {
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };
    String digitsStr = "";

    public List<String> letterCombinations(String digits) {

        digitsStr = digits;
        size = digitsStr.length();

        go(0, "");

        return result;
    }

    public void go(int idx, String val) {
        if(idx >= size) {
            if(val.length() > 0) {
                result.add(val);
            }
            return;
        }

        int cur = Integer.parseInt(String.valueOf(digitsStr.charAt(idx)));
        String curNums = nums[cur];
        int size = curNums.length();

        for(int i=0; i<size; i++) {
            val += curNums.charAt(i);
            go(idx + 1, val);
            val = val.substring(0, val.length() - 1);
        }
    }
}