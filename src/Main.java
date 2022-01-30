import java.util.Locale;

class Solution {
    public String capitalizeTitle(String title) {
        // 1. init
        String[] titleArr = title.split(" ");
        StringBuilder res = new StringBuilder();

        // 2. loop
        for(int i=0; i<titleArr.length; i++) {
            String t = titleArr[i];
            res.append(t.length() > 2 ? t.substring(0, 1).toUpperCase() + t.substring(1).toLowerCase() : t.toLowerCase());
            if(i != titleArr.length - 1) res.append(" ");
        }

        return res.toString();
    }
}