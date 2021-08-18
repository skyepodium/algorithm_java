class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 1. init
        int n = matrix.length;
        int m = matrix[0].length;

        // 2. verticalBinarySearch
        int vIdx = verticalBinarySearch(0, n-1, matrix, target);

        if (vIdx < 0) return false;

        // 3. horizontalBinarySearch
        return horizontalBinarySearch(0, m-1, matrix, target, vIdx);
    }

    public boolean horizontalBinarySearch(int l, int r, int[][] matrix, int target, int vIdx) {
        while(l <= r) {
            int mid = l + (r-l) / 2;
            int cur = matrix[vIdx][mid];

            if(cur < target) {
                l = mid + 1;
            }
            else if(cur > target) {
                r = mid - 1;
            }
            else{
                return true;
            }
        }
        return false;
    }

    public int verticalBinarySearch(int l, int r, int[][] matrix, int target) {

        while (l < r) {
            int mid = l + (r-l) / 2;
            int cur = matrix[mid][0];

            if(cur < target) {
                l = mid + 1;
            }
            else {
                r = mid;
            }
        }
        return matrix[r][0] > target ? r - 1 : r;
    }
}

class Main {
    public static void main(String[] args) {
        Solution sl = new Solution();

        int[][] matrix = {{1}};
        int target = 0;

        boolean res = sl.searchMatrix(matrix, target);

        System.out.println("res " + res);

    }
}