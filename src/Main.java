import java.util.Stack;
import java.util.stream.Collectors;

class Solution {
    public String makeFancyString(String s) {
        // 1. init
        Stack<Info> st = new Stack<>();

        // 2. loop
        for(String c: s.split("")) {
            Info cur = !st.isEmpty() ? st.peek() : new Info("", 0);

            String a = cur.c;
            int b = cur.cnt;

            if(a.equals(c) && b == 2) continue;

            int cnt = a.equals(c) ? b + 1 : 1;

            st.push(new Info(c, cnt));
        }

        return String.join("", st.stream().map(x -> x.c).collect(Collectors.toList()).toArray(new String[0]));
    }
}

class Info {
    String c;
    int cnt;
    public Info(String c, int cnt) {
        this.c = c;
        this.cnt = cnt;
    }
}

class Main {
    public static void main(String[] args) {
        Solution sl = new Solution();
        String s = "leeetcode";
        String res = sl.makeFancyString(s);

        System.out.println(res);
    }
}