class Solution {
    public String licenseKeyFormatting(String s, int k) {
        s = new StringBuilder(s.replaceAll("-", "").toUpperCase()).reverse().toString();
        int n = s.length();

        StringBuilder t = new StringBuilder();
        for(int i=0; i<n; i+=k) {
            t.append(s.substring(0, i+k));
            if(i+k < n) t.append("-");
        }

        return t.reverse().toString();
    }
}