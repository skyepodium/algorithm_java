import java.util.*;
import java.util.stream.Collectors;

class Solution {
    Map<String, List<String>> d;
    Map<String, Integer> check;
    public int solution(String begin, String target, String[] words) {
        // 1. init
        d = new HashMap<>();
        check = new HashMap<>();
        List<String> w = Arrays.stream(words).collect(Collectors.toList());
        w.add(begin);

        // 2. loop
        for(int i=0; i<w.size(); i++) {
            for(int j=0; j<w.size(); j++) {
                if(i == j) continue;
                String a = w.get(i);
                String b = w.get(j);
                if(getDiff(a, b) == 1) {
                    List<String> q = d.getOrDefault(a, new ArrayList<>());
                    q.add(b);
                    d.put(a, q);

                    List<String> e = d.getOrDefault(b, new ArrayList<>());
                    e.add(a);
                    d.put(b, e);
                }
            }
        }

        // 3. bfs
        bfs(begin);

        return check.getOrDefault(target, 0);
    }

    public int getDiff(String a, String b) {
        int res = 0;
        int n = Math.min(a.length(), b.length());
        for(int i=0; i<n; i++) {
            if(a.charAt(i) != b.charAt(i)) res++;
        }
        return res;
    }

    public void bfs(String startNode) {
        Queue<String> q = new LinkedList<>();
        q.add(startNode);
        check.put(startNode, 0);

        while(!q.isEmpty()) {
            String node = q.poll();
            for(String nNode: d.getOrDefault(node, new ArrayList<>())) {
                if(!check.containsKey(nNode)) {
                    check.put(nNode, check.get(node) + 1);
                    q.add(nNode);
                }
            }
        }
    }
}