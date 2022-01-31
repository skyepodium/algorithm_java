import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 1. init
        int[] res = new int[k];
        Map<Integer, Integer> m = new HashMap<>();
        List<Info> numList = new ArrayList<>();
        int idx = 0;

        // 2. count
        Arrays.stream(nums).forEach(x -> {
            if(m.containsKey(x)) m.put(x, m.get(x) + 1);
            else m.put(x, 1);
        });

        // 3. to list
        m.keySet().stream().forEach(x -> {
            numList.add(new Info(x, m.get(x)));
        });

        // 4. sort
        numList.sort((a, b) -> b.cnt - a.cnt);

        // 5. result
        for(Info info: numList) {
            if(idx >= k) break;
            res[idx] = info.num;
            idx++;
        }

        return res;
    }
}

class Info {
    int num;
    int cnt;
    public Info (int num, int cnt) {
        this.num = num;
        this.cnt = cnt;
    }
}

class Main {
    public static void main(String[] args) {

        Solution sl = new Solution();
        int[] nums = {1,1,1,2,2,3};
        int[] res = sl.topKFrequent(nums, 2);
        for(int i=0; i<res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }
}