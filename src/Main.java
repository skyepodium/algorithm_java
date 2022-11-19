import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public int openLock(String[] deadends, String target) {

        return bfs("0000", target, deadends);
    }

    public String getNextNode(String node, int index, int direction) {
        // up
        int nextBit = 0;
        if(direction == 0) {
            nextBit = (node.charAt(index) - '0' + 1) % 10;
        }

        if(direction == 1) {
            nextBit = (node.charAt(index) - '0' - 1 + 10) % 10;
        }

        if(nextBit < 0) nextBit = 9;

        return node.substring(0, index) + nextBit + node.substring(index + 1);
    }

    public int bfs(String startNode, String endNode, String[] deadends) {
        HashSet<String> deads = new HashSet<>(Arrays.asList(deadends));
        HashSet<String> q1 = new HashSet<>();
        HashSet<String> q2 = new HashSet<>();
        q1.add(startNode);
        q2.add(endNode);

        HashSet<String> visited = new HashSet<>();
        int step = 0;

        while(!q1.isEmpty() && !q2.isEmpty()) {
            if (q1.size() > q2.size()) {
                HashSet<String> tmp = q1;
                q1 = q2;
                q2 = tmp;
            }

            HashSet<String> temp = new HashSet<>();
            for(String node: q1) {
                if(deads.contains(node)) continue;

                if(q2.contains(node)) return step;

                visited.add(node);

                for(int i=0; i<4; i++) {
                    for(int j=0; j<2; j++) {
                        String nextNode = getNextNode(node, i, j);
                        if(visited.contains(nextNode)) continue;
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
        
    }
}