import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // 1. init
        ListNode head = null, node = null;
        List<List<Integer>> l = new ArrayList<>();
        PriorityQueue<Info> pq = new PriorityQueue<>(new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                return o1.val - o2.val;
            }
        });

        // 2. make list
        for(int i=0; i<lists.length; i++) {
            ListNode cur = lists[i];
            List<Integer> c = new ArrayList<>();
            while(cur != null) {
                c.add(cur.val);
                cur = cur.next;
            }

            l.add(c);
            if(c.size() > 0) pq.add(new Info(c.get(0), 0, i));
        }

        // 3. search pq
        while(!pq.isEmpty()) {
            Info c = pq.poll();
            int val = c.val;
            int innerIdx = c.innerIdx;
            int listIdx = c.listIdx;

            if(innerIdx <= l.get(listIdx).size()-1) {
                pq.add(new Info(l.get(listIdx).get(innerIdx + 1), innerIdx + 1, listIdx));
            }

            if(node == null) {
                head = node = new ListNode(val, null);
                node = node.next;
            }else{
                node.next = new ListNode(val, null);
                node = node.next;
            }
        }

        return head;
    }
}

class Info {
    int val;
    int innerIdx;
    int listIdx;

    public Info(int val, int innerIdx, int listIdx) {
        this.val = val;
        this.innerIdx = innerIdx;
        this.listIdx = listIdx;
    }
}