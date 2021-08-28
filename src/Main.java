class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode root = head;

        while(head != null) {
            if(head.next != null && head.val == head.next.val) {
                head.next = head.next.next;
            }
            else{
                head = head.next;
            }
        }


        return root;
    }
}