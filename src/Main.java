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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if((l1 == null) || (l2 != null && l1.val > l2.val)) {
            ListNode temp = null;
            temp = l1;
            l1 = l2;
            l2 = temp;
        }

        if(l1 != null) {
            l1.next = this.mergeTwoLists(l1.next, l2);
        }

        return l1;
    }
}