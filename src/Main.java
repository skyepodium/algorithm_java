import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class Solution {
    public String[] solution(String[] files) {
        // 1. init
        List<Info> fList =  splitFile(files);
        int size = files.length;
        String[] res = new String[size];

        // 2. sort
        fList = fList.stream().sorted((a, b) -> {
            if (a.head.toLowerCase().equals(b.head.toLowerCase())) {
                if(a.number == b.number) {
                    return a.idx - b.idx;
                }
                else {
                    return a.number - b.number;
                }
            }
            return a.head.toLowerCase().compareTo(b.head.toLowerCase());
        }).collect(Collectors.toList());

        // 3. loop
        for(int i=0; i<size; i++) {
            res[i] = fList.get(i).file;
        }

        return res;
    }

    public ArrayList<Info> splitFile(String[] files) {
        ArrayList<Info> res = new ArrayList<>();

        int idx = 0;
        for(String s: files) {
            // 1. head
            Pattern headPattern = Pattern.compile("[^0-9]+");
            Matcher headMatch = headPattern.matcher(s);
            String head = "";
            if(headMatch.find()) head = headMatch.group(0);

            // 2. number
            Pattern numberPatther = Pattern.compile("\\d{1,5}");
            Matcher numberMatch = numberPatther.matcher(s);
            String strNumber = "";
            if(numberMatch.find()) strNumber = numberMatch.group(0);
            int number = Integer.parseInt(strNumber);

            // 3. add
            res.add(new Info(head, number, idx, s));
        }

        return res;
    }
}

class Info {
    String head;
    int number;
    int idx;
    String file;

    public Info(String head, int number, int idx, String file) {
        this.head = head;
        this.number = number;
        this.idx = idx;
        this.file = file;
    }
}

class Main {
    public static void main(String[] args) {
        String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};

        Solution sl = new Solution();

        String[] res = sl.solution(files);

        for(String s: res) {
            System.out.println(s);
        }
    }
}