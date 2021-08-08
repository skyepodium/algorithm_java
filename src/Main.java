class Main {
    public static void main(String[] args) {
        Solution sl = new Solution();

        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};

        int res = sl.trap(height);

        System.out.println(res);
    }
}

class Solution {
    public int trap(int[] height) {

        int result = 0;

        // 1. 왼쪽, 오른쪽 최대 높이를 저장할 변수 생성
        int l = 0;
        int r = height.length - 1;
        int leftMax = height[l];
        int rightMax = height[r];

        while(l <= r) {
            // 2. 투 포인터 왼쪽, 오른쪽 최대값 갱신
            leftMax = Math.max(leftMax, height[l]);
            rightMax = Math.max(rightMax, height[r]);

            // 3. 최대 높이를 향해 투 포인터 이동
            if(leftMax <= rightMax) {
                result += leftMax - height[l];
                l++;
            }
            else {
                result += rightMax - height[r];
                r--;
            }
        }

        return result;
    }
}