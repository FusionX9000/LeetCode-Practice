package LeetCode.Q141LinkedListCycle;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean detectCycle(ListNode head) {
        if(head==null || head.next==null) return false;
        Set<ListNode> set = new HashSet<>();
        ListNode node = head;
        while(node!=null && !set.contains(node)) {
            set.add(node);
            node=node.next;
        }
        return node!=null;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;
        System.out.println(s.detectCycle(head));
    }
}
