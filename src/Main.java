class Solution {
    public int addDigits(int num) {

        while(num >= 10) {
            int n = num;
            int res = 0;

            while(n > 0) {
                res += n % 10;
                n /= 10;
            }
            num = res;
        }

        return num;
    }
}