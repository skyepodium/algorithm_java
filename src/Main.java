import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.mySqrt(1));
    }
}

class Solution {
    public int mySqrt(int x) {

        Long l = 0L;
        Long r = new Long(x);
        Long result = 0L;

        while(l <= r) {
            Long mid = (l + r) / 2;
            Long val = mid * mid;

            if(val > x) {
                r = mid - 1;
            }
            else if(val == x) {
                return mid.intValue();
            }
            else{
                result = mid;
                l = mid + 1;
            }
        }

        return result.intValue();
    }
}