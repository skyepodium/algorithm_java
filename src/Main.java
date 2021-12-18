class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int cnt = 0;

        for(int i=0; i<stones.length(); i++) {
            String cur = stones.charAt(i) + "";

            if(jewels.contains(cur)) cnt++;
        }

        return cnt;
    }
}