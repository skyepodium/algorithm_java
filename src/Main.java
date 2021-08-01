import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();

        int d[] = {8, 9, 9, 9};

        int a[] = s.plusOne(d);

        for(int num: a) {
            System.out.println(num);
        }
    }
}

class Solution {
    public int[] plusOne(int[] digits) {
        int size =digits.length;
        int idx = size - 1;
        digits[idx] += 1;

        while (idx >= 0) {
            int val = digits[idx];

            if(val >= 10) {
                digits[idx] = 0;

                if(idx == 0) {
                    int []result_list = new int[size + 1];
                    result_list[0] = 1;

                    for(int i=1; i<size; i++) {
                        result_list[i] = digits[i-1];
                    }

                    return result_list;
                }
                else{
                    digits[idx-1] += 1;
                }
            }
            idx--;
        }

        return digits;
    }
}