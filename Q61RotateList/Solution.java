package LeetCode.Q61RotateList;

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null) return head;
        int length = 1;
        ListNode node = head;

        while(node.next!=null) {
            length++;
            node=node.next;
        }

        k=k%length;
        if(k==0) return head;

        node.next=head;
        k=length-k;

        while(k-- > 0) {
            node=node.next;
        }

        head = node.next;
        node.next=null;
        return head;
    }
}
