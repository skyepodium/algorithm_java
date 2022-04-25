import java.util.*;

class Solution {
    int baseMinute;
    int baseFee;
    int perMinute;
    int perFee;
    public int[] solution(int[] fees, String[] records) {
        // 1. init
        baseMinute = fees[0];
        baseFee = fees[1];
        perMinute = fees[2];
        perFee = fees[3];

        Map<String,List<Integer>> p = new HashMap<>();
        Map<String,Integer> remain = new HashMap<>();
        Map<String,Integer> res = new HashMap<>();

        // 2. loop
        for(String r: records) {
            String[] a = r.split(" ");
            String[] t = a[0].split(":");
            String num = a[1];
            int curHour = Integer.parseInt(t[0]);
            int curMinute = Integer.parseInt(t[1]);

            if(a[2].equals("IN")) {
                List<Integer> b = new ArrayList<>();
                b.add(curHour);
                b.add(curMinute);
                p.put(num, b);
            }
            else {
                int diff = calDiff(p.get(num).get(0), p.get(num).get(1), curHour, curMinute);
                remain.put(num, remain.getOrDefault(num, 0) + diff);
                p.remove(num);
            }
        }

        // 3. sumTime
        p.forEach((num, value) -> {
            int diff = calDiff(value.get(0), value.get(1), 23, 59);
            remain.put(num, remain.getOrDefault(num, 0) + diff);
        });

        // 4. total fee
        remain.forEach((key, value) -> res.put(key, calFee(value)));

        return res.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .mapToInt(x -> x)
                .toArray();
    }

    public int calDiff(int beforeHour, int beforeMinute, int curHour, int curMinute) {
        int hourDiff = curHour - beforeHour;
        int minuteDiff = curMinute - beforeMinute;

        if(minuteDiff < 0) {
            hourDiff -= 1;
            minuteDiff += 60;
        }

        return hourDiff * 60 + minuteDiff;
    }

    public int calFee (int diff) {
        int res = baseFee;

        if(diff > baseMinute) {
            int mdiff = diff - baseMinute;
            int a = mdiff / perMinute;
            if(mdiff % perMinute != 0) a += 1;
            res += a * perFee;
        }
        return res;
    }
}

class Main {
    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

        Solution sl = new Solution();
        int[] res = sl.solution(fees, records);

        Arrays.stream(res).forEach(System.out::println);
    }
}