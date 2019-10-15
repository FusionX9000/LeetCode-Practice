package LeetCode.Q21MergeTwoSortedLists;

import LeetCode.Utility.ListNode;
import LeetCode.Utility.UsefulMethods;

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while(l1!=null && l2!=null) {
            if(l1.val<=l2.val) {
                head.next = l1;
                l1=l1.next;
            } else {
                head.next=l2;
                l2=l2.next;
            }
            head=head.next;
        }
        head.next= l1!=null ? l1 : l2;
        return dummy.next;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode l1 = new ListNode(3,5,9,10,15);
        ListNode l2 = new ListNode(1,2,4,8,9,10,11,19,20);
        UsefulMethods.printListNode(l1);
        UsefulMethods.printListNode(l2);
        UsefulMethods.printListNode(s.mergeTwoLists(l1,l2));
    }
}
