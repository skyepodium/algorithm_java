import java.util.Arrays;

class Main {
    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 4};
        int[] nums = {1, 2, 7, 6, 4};

        Solution sl = new Solution();

        int res = sl.solution(nums);
        System.out.println(res);
    }
}

class Solution {
    public int solution(int[] nums) {
        // 1. init
        int answer = 0;

        // 2. sort
        Arrays.sort(nums);

        // 3. setting
        int size = nums.length;
        int maxInt = nums[size-1] + nums[size-2] + nums[size-3];
        int[] d = new int[maxInt + 1];

        // 4. eratos
        for(int i=2; i<=maxInt; i++){
            for(int j=i+i; j<=maxInt; j=j+i) {
                if(d[j] == 0) {
                    d[j] = 1;
                }
            }
        }

        // 5. nested loop
        for(int i=0; i<size-2; i++) {
            for(int j=i+1; j<size-1; j++) {
                for(int k=j+1; k<size; k++) {
                    if(d[nums[i] + nums[j] + nums[k]] == 0) {
                        answer += 1;
                    }
                }
            }
        }

        return answer;
    }
}