import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // 1. init
        ListNode head = null, node = null;
        List<Integer> l = new ArrayList<>();

        // 2. loop
        for(ListNode c: lists) {
            while(c != null) {
                l.add(c.val);
                c = c.next;
            }
        }

        // 3. sort
        l.sort(Comparator.comparingInt(a -> a));

        // 4. loop
        for(Integer n: l) {
            if(node == null) {
                head = node = new ListNode(n, null);
            }
            else {
                node.next = new ListNode(n, null);
                node = node.next;
            }
        }

        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
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