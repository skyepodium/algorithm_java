import java.util.ArrayList;

class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean isPalindrome(ListNode head) {

        ArrayList<Integer> result = new ArrayList<>();

        // 1. 연결 리스트를 모두 꺼내서 리스트에 넣어줍니다.
        while(head != null) {
            result.add(head.val);
            head = head.next;
        }

        // 2. 투 포인터를 사용해서 팰린드롬 여부를 반환합니다.
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
