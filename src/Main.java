import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public String reverseWords(String s) {
        String[] stringArray = s.trim().split(" +");

        List<String> list = new ArrayList<>(Arrays.asList(stringArray));
        Collections.reverse(list);

        // list to string
        return String.join(" ", list);
    }
}