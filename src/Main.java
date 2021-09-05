import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fizzBuzz(int n) {
        // 1. init
        List<String> res = new ArrayList<>();

        // 2. loop
        for(int i=1; i<=n; i++) {
            if(i%3 == 0 && i%5==0) {
                res.add("FizzBuzz");
            }
            else if(i%3 == 0) {
                res.add("Fizz");
            }
            else if(i%5 == 0) {
                res.add("Buzz");
            }
            else {
                res.add(Integer.toString(i));
            }
        }

        return res;
    }
}