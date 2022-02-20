import java.util.HashMap;
import java.util.Map;

class Solution {
    public String reformatDate(String date) {
        // 1. init
        Map<String, String> m = new HashMap<>();
        m.put("Jan", "01");
        m.put("Feb", "02");
        m.put("Mar", "03");
        m.put("Apr", "04");
        m.put("May", "05");
        m.put("Jun", "06");
        m.put("Jul", "07");
        m.put("Aug", "08");
        m.put("Sep", "09");
        m.put("Oct", "10");
        m.put("Nov", "11");
        m.put("Dec", "12");

        // 2. split
        String[] d = date.split(" ");
        String day = d[0].replaceAll("[a-zA-z]", "");

        return d[2] + "-" + m.get(d[1]) + "-" + zFill(day);
    }

    public String zFill(String strNum){
        return strNum.length() < 2 ? "0" + strNum : strNum;
    }
}