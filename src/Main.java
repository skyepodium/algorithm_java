class Solution {
    public String addStrings(String num1, String num2) {
        // 1. init
        int n = num1.length() - 1;
        int m = num2.length() - 1;

        char[] num1Array = num1.toCharArray();
        char[] num2Array = num2.toCharArray();

        // 2. loop
        int carry = 0;
        String res = "";
        while(n >= 0 || m >= 0 || carry > 0) {
            int a = n >= 0 ? num1Array[n--] - '0' : 0;
            int b = m >= 0 ? num2Array[m--] - '0' : 0;

            int sumVal = a + b + carry;
            carry = sumVal / 10;
            int val = sumVal % 10;
            res += Integer.toString(val);
        }

        // 3. reverse
        StringBuffer sb = new StringBuffer(res);
        return sb.reverse().toString();
    }
}