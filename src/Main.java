import java.util.ArrayList;

class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean isPalindrome(ListNode head) {

        ArrayList<Integer> result = new ArrayList<>();

        ListNode node = head;

        while(node != null) {
            result.add(node.val);
            node = node.next;
        }

        int l = 0;
        int r = result.size() - 1;

        while(l < r) {
            if(result.get(l) != result.get(r)) return false;
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
