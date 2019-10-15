package LeetCode.Q142LinkedListCycleII;

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null) return null;

        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast) break;
        }

        if(fast==null || fast.next==null) return null;
        slow = head;
        while(slow!=fast) {
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;
        System.out.println(s.detectCycle(head).val);
    }
}
