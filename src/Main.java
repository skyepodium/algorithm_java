class Solution {
    public int countSegments(String s) {
        if("".equals(s.trim())) return 0;

        return s.trim().split(" +").length;
    }
}