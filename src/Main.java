class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int cnt = 0;
        for(int i=0; i<arr.length; i++) {
            if((arr[i] & 1) == 0) cnt = 0;
            else {
                cnt++;
                if(cnt >+ 3) return true;
            }
        }
        return false;
    }
}