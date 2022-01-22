import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public String[] reorderLogFiles(String[] logs) {

        // 1. init
        List<String> letters = new ArrayList<>();
        List<String> digits = new ArrayList<>();

        // 2. loop
        Arrays.stream(logs).forEach(x -> {
            if(isDigit(x.split(" ")[1])) digits.add(x);
            else letters.add(x);
        });

        // 3. sort
        Collections.sort(letters, (a, b) -> {
            String[] first = a.split(" ", 2);
            String[] second = b.split(" ", 2);

            if(first[1].equals(second[1])) {
                return first[0].compareTo(second[0]);
            } else{
                return first[1].compareTo(second[1]);
            }
        });

        // 4. to array
        letters.addAll(digits);
        String[] res = new String[letters.size()];
        return letters.toArray(res);
    }

    // 5. check isDigit
    public Boolean isDigit(String s) {
        int size = s.length();
        for(int i=0; i<size; i++) {
            if(!Character.isDigit(s.charAt(i))) return false;
        }
        return true;
    }
}