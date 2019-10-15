package LeetCode.Q25ReverseNodesInKGroup;

import LeetCode.Utility.ListNode;
import LeetCode.Utility.UsefulMethods;

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || head.next==null) return head;
        ListNode dummy = head;
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.next;
        int counter=0;
        while(counter!=k && dummy!=null) {
            dummy = dummy.next;
            counter++;
        }
        if(counter!=k) return head;
        while(--counter>0 && next!=null) {
            ListNode temp = next.next;
            curr.next=prev;
            prev=curr;
            next.next = curr;
            curr=next;
            next = temp;
        }
        ListNode rest = reverseKGroup(next,k);
        UsefulMethods.printListNode(rest);
        head.next=rest;
        return curr;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = new ListNode(1,2,3,4,5);
        UsefulMethods.printListNode(s.reverseKGroup(head,3));
    }

}
