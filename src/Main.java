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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // 1. init
        ListNode node = new ListNode(0);
        ListNode res = node;

        int carry = 0;
        while(l1 != null || l2 != null || carry > 0) {
            int sumVal = 0;

            if(l1 != null) {
                sumVal += l1.val;
                l1 = l1.next;
            }

            if(l2 != null) {
                sumVal += l2.val;
                l2 = l2.next;
            }

            int val = (sumVal + carry) % 10;
            carry = (sumVal + carry) / 10;

            node.next = new ListNode(val);;
            node = node.next;
        }

        return res.next;
    }
}

