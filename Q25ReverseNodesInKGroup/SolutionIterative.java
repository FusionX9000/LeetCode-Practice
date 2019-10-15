package LeetCode.Q25ReverseNodesInKGroup;

import LeetCode.Utility.ListNode;
import LeetCode.Utility.UsefulMethods;

public class SolutionIterative {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || head.next==null) return null;
        int n = 0;
        for(ListNode node = head; node!=null; node=node.next,n++);
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        for(ListNode prev = dummy, curr=head;n>=k;n-=k) {
            for(int i = 1; i<k; i++) {
                ListNode next = curr.next.next;
                curr.next.next = prev.next;
                prev.next=curr.next;
                curr.next=next;
            }
            prev=curr;
            curr=curr.next;
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        SolutionIterative s = new SolutionIterative();
        ListNode head = new ListNode(1,2,3,4,5);
        UsefulMethods.printListNode(s.reverseKGroup(head,3));
    }
}