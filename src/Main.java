import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) {

        Solution sl = new Solution();

        List<Integer> res = sl.selfDividingNumbers(1, 22);
        res.stream().forEach(System.out::println);
    }
}

class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {

        return IntStream.range(left, right + 1)
                        .filter(this::check)
                        .boxed()
                        .collect(Collectors.toList());
    }

    public boolean check(int num) {
        String strNum = Integer.toString(num);

        for(int i=0; i<strNum.length(); i++) {
            char cur = strNum.charAt(i);

            if(cur == '0') return false;

            if(num % ((int)cur - (int)'0') != 0) return false;
        }
        return true;
    }
}