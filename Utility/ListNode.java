package LeetCode.Utility;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }
    public ListNode(int ...x) {
        val = x[0];
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        for(int i=1;i<x.length;i++) {
            temp.next = new ListNode(x[i]);
            temp=temp.next;
        }
        next=dummy.next;
    }
    public void add(int x) {
        next= new ListNode(x);
    }
}
