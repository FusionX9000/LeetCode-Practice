package LeetCode.Q146LRUCache;

import java.util.HashMap;
import java.util.List;

public class DDLinkList {
    private ListNode head;
    private ListNode tail;

    public DDLinkList() {
        head = new ListNode();
        tail = new ListNode();
        head.next=tail;
        tail.prev=head;
    }

    public ListNode getHead() { return head.next; }
    public ListNode getTail() { return tail.prev; }

    public void removeNode(ListNode node) {
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }

    public void addNode(ListNode node) {
        ListNode n = head.next;
        node.prev = head;
        node.next = n;
        n.prev = node;
        head.next=node;
    }

    public void print() {
        ListNode node = getHead();
        while(node!=tail) {
            System.out.print(node.val+" ---> ");
            node=node.next;
        }
        System.out.println("NULL");
    }

}
