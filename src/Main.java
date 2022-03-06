import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        Solution sl = new Solution();
//        int[] arr = {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3};
//        int[] arr = {6,2,7,5,1,2,0,3,10,2,5,0,5,5,0,8,7,6,8,0};
        int[] arr = {6,0,7,0,7,5,7,8,3,4,0,7,8,1,6,8,1,1,2,4,8,1,9,5,4,3,8,5,10,8,6,6,1,0,6,10,8,2,3,4};
        double res = sl.trimMean(arr);

        System.out.println("res " + res);

    }
}

class Solution {
    public double trimMean(int[] arr) {
        // 1. sort
        Arrays.sort(arr);

        // 2. sub
        int n = arr.length;
        int cnt = (int) (n * 0.05);
        int m = n - cnt * 2;
        double s = 0;

        for(int i=cnt; i<n-cnt; i++) s += arr[i];

        return s / m;
    }
}