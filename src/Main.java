import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean isPalindrome(ListNode head) {
        // 1. init
        List<Integer> valList = new ArrayList<>();

        // 2. loop
        while(head != null) {
            valList.add(head.val);
            head = head.next;
        }

        // 3. two pointer
        int l = 0;
        int r = valList.size() - 1;

        while(l < r) {
            if(valList.get(l) != valList.get(r)) return false;

            l++;
            r--;
        }

        return true;
    }
}

class ListNode {
int val;
ListNode next;
ListNode() {}
ListNode(int val) { this.val = val; }
ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
