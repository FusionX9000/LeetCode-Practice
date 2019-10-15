package LeetCode.Q19RemoveNthNodeFromEndOfList;

import LeetCode.Utility.ListNode;
import LeetCode.Utility.UsefulMethods;

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        if(n==0) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode l = dummy;
        ListNode r = dummy;
        while(count<=n) {
            r=r.next;
            count++;
        }
        if(count-1!=n) return head;
        while(r!=null) {
            l=l.next;
            r=r.next;
        }
        System.out.println(l.next.val);
        l.next = l.next.next;
        System.out.println(head.val);
        return head;
    }
    public void print(ListNode node) {
        while(node!=null) {
            System.out.print(node.val+" --> ");
            node=node.next;
        }
        System.out.print("null\n");
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = new ListNode(1);
        UsefulMethods.printListNode(head);
        UsefulMethods.printListNode(s.removeNthFromEnd(head,1));

    }
}
