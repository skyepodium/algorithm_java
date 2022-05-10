class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        // 0. exception
        if(original.length != m * n) return new int[0][0];

        // 1. init
        int res[][] = new int[m][n];

        // 2. loop
        int i=0;
        int j=0;
        for(int o: original) {
            res[i][j] = o;
            j++;
            if(j >= n) {
                j = 0;
                i++;
            }
        }

        return res;
    }
}