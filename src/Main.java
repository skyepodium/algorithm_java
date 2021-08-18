class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 1. init
        int n = matrix.length - 1;
        int m = matrix[0].length - 1;
        int i = 0;
        int j = m;

        // 2. loop
        while (i<=n && j>=0) {
            int cur = matrix[i][j];

            if(cur > target) {
                j--;
            }
            else if (cur < target) {
                i++;
            }
            else {
                return true;
            }
        }
        return false;
    }
}

class Main {
    public static void main(String[] args) {

    }
}