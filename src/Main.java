import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] sortByBits(int[] arr) {
        // 1. init
        List<Info> arrList = new ArrayList<>();
        int[] res = new int[arr.length];

        // 2. loop
        for(int num: arr) {
            arrList.add(new Info(num, getOneCnt(num)));
        }

        // 3. sort
        arrList.sort((a, b) -> {
            if(a.oneCnt == b.oneCnt) return a.num - b.num;
            else return a.oneCnt - b.oneCnt;
        });

        int idx = 0;
        for(Info x: arrList) {
            res[idx++] = x.num;
        }

        return res;
    }

    public int getOneCnt (int num) {
        int oneCnt = 0;
        while(num > 0) {
            if(num%2 == 1) oneCnt++;
            num /= 2;
        }
        return oneCnt;
    }
}

class Info {
    int num;
    int oneCnt;
    public Info(int num, int oneCnt) {
        this.num = num;
        this.oneCnt = oneCnt;
    }
}

class Main {

}