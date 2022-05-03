class Solution {
    public boolean isPalindrome(int x) {
        String s = Integer.toString(x);

        return s.equals(new StringBuffer(s).reverse().toString());
    }
}