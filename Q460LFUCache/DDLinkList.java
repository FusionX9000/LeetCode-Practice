package LeetCode.Q460LFUCache;

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode node = getHead();
        while(node!=tail) {
            sb.append(node.val).append(" ---> ");
            node=node.next;
        }
        sb.append("NULL");
        return sb.toString();
    }

    public boolean isEmpty() {
        return head.next==tail;
    }

    public static void main(String[] args) {
        DDLinkList ddl = new DDLinkList();
        ddl.addNode(new ListNode(0,0));
        ListNode node = new ListNode(3,3);
        ddl.addNode(node);
        ddl.addNode(new ListNode(1,1));
        ddl.addNode(new ListNode(2,2));
        ddl.print();
        ddl.removeNode(node);
        ddl.print();
    }
}
