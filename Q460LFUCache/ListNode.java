package LeetCode.Q460LFUCache;

public class ListNode {
    int key;
    int val;
    int freq;
    ListNode next;
    ListNode prev;
    public ListNode(int k, int v) {
        key=k;
        val=v;
        freq=1;
    }
    public ListNode(){}
    @Override
    public String toString() {return "key: " + key + ", val: "+ val;}
}

