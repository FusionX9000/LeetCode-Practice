package LeetCode.Q141LinkedListCycle;

import java.util.HashSet;
import java.util.Set;

public class SolutionConstantSpace {
    public boolean detectCycle(ListNode head) {
        if(head==null || head.next==null) return false;
        ListNode slow = head;
        ListNode fast = head;
        do {
            slow=slow.next;
            fast=fast.next.next;
        } while((fast!=null && fast.next!=null) && slow!=fast);

        return fast!=null && fast.next!=null;
    }

    public static void main(String[] args) {
        SolutionConstantSpace s = new SolutionConstantSpace();
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;
        System.out.println(s.detectCycle(head));
    }
}
