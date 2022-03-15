class Solution {
    public String minRemoveToMakeValid(String s) {
        // 1. init
        StringBuilder res = new StringBuilder();
        int cnt = 0;

        // 2. loop
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);

            if(c == '(') {
                cnt += 1;
                res.append(c);
            }
            else if(c == ')') {
                if(cnt > 0) {
                    cnt -= 1;
                    res.append(c);
                }
            }
            else {
                res.append(c);
            }
        }

        // 3. exception
        String origin = res.toString();
        res = new StringBuilder();
        for(int i=origin.length() - 1; i>=0; i--) {
            char c = origin.charAt(i);

            if(c == '(' && cnt > 0) cnt -= 1;
            else res.append(c);
        }

        return res.reverse().toString();
    }
}
