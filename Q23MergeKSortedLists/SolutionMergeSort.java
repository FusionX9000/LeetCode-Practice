package LeetCode.Q23MergeKSortedLists;

import LeetCode.Utility.ListNode;
import LeetCode.Utility.UsefulMethods;

public class SolutionMergeSort {
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKLists(lists,0,lists.length-1);
    }
    public ListNode mergeKLists(ListNode[] lists, int lo, int hi) {
        ListNode result = null;
        if(lo==hi) result = lists[lo];
        if(lo<hi) {
            int mid = lo-(lo-hi)/2;
            ListNode node1 = mergeKLists(lists,lo,mid);
            ListNode node2 = mergeKLists(lists,mid+1,hi);
            result = merge(node1,node2);
        }
        return result;
    }

    public ListNode merge(ListNode node1, ListNode node2) {
        if(node1==null || node2==null) return node1==null ? node2: node1;
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        while(node1!=null && node2!=null) {
            if(node1.val<node2.val) {
                node.next=node1;
                node1=node1.next;
            } else {
                node.next=node2;
                node2=node2.next;
            }
            node=node.next;
        }
        if(node1!=null) node.next=node1;
        else node.next=node2;
        return dummy.next;
    }

    public static void main(String[] args) {
        SolutionMergeSort s = new SolutionMergeSort();
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
