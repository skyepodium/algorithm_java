class Solution {
    public ListNode middleNode(ListNode head) {
        // 1. init
        ListNode fast = head, slow = head;

        // 2. runner
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}