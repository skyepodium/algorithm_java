class Solution {
    public int maxProduct(String[] words) {
        // 1. init
        int n = words.length;
        int[] w = new int[n];

        for(int i=0; i<n; i++) {
            String wo = words[i];
            int bit = 0;
            for(String c: wo.split("")) {
                int val = (int)c.charAt(0) - (int)"a".charAt(0);
                bit |= 1 << val;
            }
            w[i] = bit;
        }
        int res = 0;

        // 2. loop
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                if((w[i] & w[j]) != 0) continue;

                res = Math.max(res, words[i].length() * words[j].length());
            }
        }

        return res;
    }
}