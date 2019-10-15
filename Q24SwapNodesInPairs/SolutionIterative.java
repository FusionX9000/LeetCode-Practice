package LeetCode.Q24SwapNodesInPairs;

import LeetCode.Utility.ListNode;
import LeetCode.Utility.UsefulMethods;

public class SolutionIterative {
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        ListNode tempHead = dummy;
        ListNode first = head;
        while(first!=null && first.next!=null) {
            ListNode second = first.next;
            first.next = second.next;
            second.next=first;
            tempHead.next=second;
            tempHead=first;
            first=first.next;
        }
        return dummy.next;
    }
}
