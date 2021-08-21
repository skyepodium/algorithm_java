/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        // 1. init
        ListNode rev = null;

        // 2. loop
        while(head != null) {
            ListNode temp = head;
            head = head.next;
            temp.next = rev;
            rev = temp;
        }

        return rev;
    }
}