import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean isPalindrome(ListNode head) {
        // 1. init
        ListNode rev = null;
        ListNode fast = head;
        ListNode slow = head;

        // 2. runner
        while(fast != null && fast.next != null) {
            fast = fast.next.next;

            ListNode temp = slow;
            ListNode prev = rev;
            slow = slow.next;
            rev = temp;
            rev.next = prev;
        }

        // 3. check
        if(fast != null) slow = slow.next;

        // 4. loop
        while(rev != null && rev.val == slow.val) {
            slow = slow.next;
            rev = rev.next;
        }

        return rev == null;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
}