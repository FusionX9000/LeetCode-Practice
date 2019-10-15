package LeetCode.Q23MergeKSortedLists;

import LeetCode.Utility.ListNode;
import LeetCode.Utility.UsefulMethods;

import java.util.*;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
//        Queue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
//            @Override public int compare(ListNode l1, ListNode l2) {
//                return l1.val-l2.val;
//            }
//        });
        Queue<ListNode> queue = new PriorityQueue<>(lists.length,(l1,l2)-> l1.val-l2.val);
        ListNode head = new ListNode(0), tail = head;
        for(ListNode node : lists) if(node!=null) queue.offer(node);
        while(!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;
            if(tail.next!=null) queue.offer(tail.next);
        }
        return head.next;
    }
    public static void main(String[] args){
        Solution s = new Solution();
        ListNode n1 = new ListNode(1,4,5);
        ListNode n2 = new ListNode(1,3,4);
        ListNode n3 = new ListNode(5,9,12);
        ListNode[] lists = new ListNode[]{n1,n2,n3};
        for(ListNode n : lists) {
            UsefulMethods.printListNode(n);
        }
        UsefulMethods.printListNode(s.mergeKLists(lists));
    }
}
