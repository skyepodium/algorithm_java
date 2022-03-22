import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        // 1. init
        Map<String, Integer> d = new HashMap<>();
        d.put("type", 0);
        d.put("color", 1);
        d.put("name", 2);
        int res = 0;

        // 2. loop
        for(List<String> i: items) {
            if(i.get(d.get(ruleKey)).equals(ruleValue)) res++;
        }

        return res;
    }
}