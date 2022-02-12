class Solution {
    public ListNode deleteMiddle(ListNode head) {
        // 1. init
        ListNode node = new ListNode(-1);
        ListNode fast = node, slow = node;
        node.next = head;

        // 2. runner
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 3. delete
        slow.next = slow.next.next;

        return node.next;
    }
}