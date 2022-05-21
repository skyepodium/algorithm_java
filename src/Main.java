class Solution {
    public int coinChange(int[] coins, int amount) {
        // 1. init
        int[] d = new int[amount+1];
        for(int i=1; i<=amount; i++) d[i] = amount + 1;
        d[0] = 0;

        // 2. bottom up
        for(int i=1; i<=amount; i++) {
            for(int c: coins) {
                if(i-c>=0) {
                    d[i] = Math.min(d[i], d[i-c] + 1);
                }
            }
        }

        return d[amount] <= amount ? d[amount] : -1;
    }
}

class Main {
    public static void main(String[] args) {
        Solution sl = new Solution();
        int[] coins = {2};
        int amount = 3;
        int res = sl.coinChange(coins, amount);

        System.out.println(res);
    }
}