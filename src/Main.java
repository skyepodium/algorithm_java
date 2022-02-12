import java.util.Stack;

class Solution {
    public ListNode deleteMiddle(ListNode head) {
        // 1. init
        ListNode fast = head, slow = head;
        Stack<Integer> s = new Stack<>();

        // 2. runner
        while(fast != null && fast.next != null) {
            s.add(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }

        // 3. stack
        ListNode res = slow.next;
        while(!s.empty()) {
            res = new ListNode(s.pop(), res);
        }

        return res;
    }
}