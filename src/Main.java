/*
시간 복잡도: O(n)
공간 복잡도: O(n)
사용한 알고리즘: 반복문
사용한 자료구조: 트리
 */

import java.util.HashMap;

class Solution {

    public static int n, m, idx;
    public static HashMap<String, String> p = new HashMap<>();
    public static HashMap<String, Integer> idxMap = new HashMap<>();

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        // 1. init
        n = enroll.length;
        m = seller.length;
        int[] answer = new int[n];

        // 2. make tree
        for(int i=0; i<n; i++) {
            String e = enroll[i];
            String r = referral[i];
            p.put(e, r);
            idxMap.put(e, idx);
            idx++;
        }

        // 3. loop
        for(int i=0; i<m; i++) {
            String s = seller[i];
            int a = amount[i] * 100;
            String cur = s;

            float remain = a;
            while(remain > 0 && !cur.equals("-")) {
                // 1) check
                int curIdx = idxMap.get(cur);

                // 2) calculate
                int upper = (int)(remain * 0.1);
                int mine = (int)remain - upper;

                if(upper < 1) {
                    mine = (int)remain;
                    upper = 0;
                }

                // 3) update
                answer[curIdx] += mine;
                cur = p.get(cur);
                remain = upper;
            }
        }
        return answer;
    }
}

class Main {
    public static void main(String[] args) {
        Solution sl = new Solution();

    }
}