package LeetCode.Q146LRUCache;

import java.util.HashMap;

public class LRUCache {
    private int capacity;
    private int size;
    private HashMap<Integer, ListNode> nodesMap;
    private DDLinkList ddl;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        nodesMap = new HashMap<>();
        ddl = new DDLinkList();
    }

    public int get(int key) {
        if(!nodesMap.containsKey(key)) {
            System.out.print(-1+", ");
            return -1;
        }
        refreshPriority(nodesMap.get(key));
        return nodesMap.get(key).val;
    }

    public void put(int key, int value) {
        System.out.print("null, ");
        ListNode node;
        if(capacity==0) return;
        if(capacity==size && !nodesMap.containsKey(key)) {
            size--;
            nodesMap.remove(ddl.getTail().key);
            ddl.removeNode(ddl.getTail());
        }
        if(nodesMap.containsKey(key)) {
            node = nodesMap.get(key);
            refreshPriority(node);
            node.val = value;
        } else {
            size++;
            node = new ListNode(key,value);
            ddl.addNode(node);
        }
        nodesMap.put(key,node);
    }

    public void refreshPriority(ListNode node) {
        ddl.removeNode(node);
        ddl.addNode(node);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.put(1,1);
        cache.put(2,2);
        cache.put(3,3);
        cache.put(4,4);
        cache.get(4);
        cache.get(3);
        cache.get(2);
        cache.get(1);
        cache.put(5,5);
        cache.get(1);
        cache.get(2);
        cache.get(3);
        cache.get(4);
        cache.get(5);
    }
}

