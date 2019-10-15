package LeetCode.Q24SwapNodesInPairs;

import LeetCode.Utility.ListNode;
import LeetCode.Utility.UsefulMethods;

public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode first = head;
        ListNode second = head.next;
        ListNode rest = swapPairs(second.next);
        second.next=first;
        first.next = rest;
        return second;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode node = new ListNode(1,2,3,4);
        UsefulMethods.printListNode(node);
        UsefulMethods.printListNode(s.swapPairs(node));
    }
}
