import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public int openLock(String[] deadends, String target) {

        return bfs("0000", target, deadends);
    }

    public String getNextNode(String node, int index, int direction) {
        StringBuilder sb = new StringBuilder(node);

        // up
        int nextBit = 0;
        if(direction == 0) {
            nextBit = (node.charAt(index) - '0' + 1) % 10;
        }

        // down
        if(direction == 1) {
            nextBit = (node.charAt(index) - '0' - 1 + 10) % 10;
        }

        return sb.replace(index, index + 1, String.valueOf(nextBit)).toString();
    }

    public int bfs(String startNode, String endNode, String[] deadends) {
        HashSet<String> q1 = new HashSet<>();
        HashSet<String> q2 = new HashSet<>();
        q1.add(startNode);
        q2.add(endNode);

        HashSet<String> visited = new HashSet<>(Arrays.asList(deadends));
        int step = 0;

        while(!q1.isEmpty() && !q2.isEmpty()) {
            if (q1.size() > q2.size()) {
                HashSet<String> tmp = q1;
                q1 = q2;
                q2 = tmp;
            }

            HashSet<String> temp = new HashSet<>();

            for(String node: q1) {
                if(visited.contains(node)) continue;
                if(q2.contains(node)) return step;
                visited.add(node);

                for(int i=0; i<4; i++) {
                    for(int j=0; j<2; j++) {
                        String nextNode = getNextNode(node, i, j);
                        if(visited.contains(nextNode)) continue;
                        System.out.println("nextNode " + nextNode);
                        temp.add(nextNode);
                    }
                }
            }
            q1 = q2;
            q2 = temp;
            step++;
        }
        return -1;
    }
}

class Main {
    public static void main(String[] args) {
        String[] deadends = {"0201","0101","0102","1212","2002"};
        String target = "0202";

        Solution sl = new Solution();
        System.out.println(sl.openLock(deadends, target));
    }
}