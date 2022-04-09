class Solution {
    public long solution(long n) {
        long num = (long) Math.sqrt(n);

        return num * num == n ? (long) Math.pow(num + 1, 2) : -1;
    }
}