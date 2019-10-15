package LeetCode.Q146LRUCache;

public class ListNode {
    int key;
    int val;
    ListNode next;
    ListNode prev;
    public ListNode(int k, int v) {
        key=k;
        val=v;
    }
    public ListNode(){}
    @Override
    public String toString() {return "key: " + key + ", val: "+ val;}
}

