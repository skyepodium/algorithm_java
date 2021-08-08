import java.util.ArrayList;
import java.util.Collections;

class Main {
    public static void main(String[] args) {
        Solution sl = new Solution();
        String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        String[] res = sl.reorderLogFiles(logs);

        for(String word: res) {
            System.out.println(word);
        }
    }
}

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        ArrayList<String> letters = new ArrayList<>();
        ArrayList<String> digits = new ArrayList<>();
         for(String log: logs) {
            String[] splitLog = log.split(" ");

            if(isDigit(splitLog[1])) digits.add(log);
            else letters.add(log);
        }

         // 3. letters 사전 순 정렬, 만약 같으면 identifier 사전 순 정렬
        Collections.sort(letters, (a, b) -> {
            String first = a.split(" ", 2)[1];
            String second = b.split(" ", 2)[1];

            if(first.equals(second)) {
                return a.split(" ")[0].compareTo(b.split(" ")[0]);
            }
            else{
                return first.compareTo(second);
            }
        });

        ArrayList<String> result = new ArrayList<>();
        result.addAll(letters);
        result.addAll(digits);
        String[] arr = new String[result.size()];

        return result.toArray(arr);
    }

    public Boolean isDigit(String s) {
        int size = s.length();
        for(int i=0; i<size; i++) {
            if(!Character.isDigit(s.charAt(i))) return false;
        }
        return true;
    }
}