import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        // 1. init
        int l = 0;
        int r = people.length - 1;
        int res = 0;

        // 2. sort
        Arrays.sort(people);

        // 3. two pointer
        while(l <= r) {
            res++;

            if(people[l] + people[r] <= limit) {
                l++;
            }
            r--;
        }

        return res;
    }
}