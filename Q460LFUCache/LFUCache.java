package LeetCode.Q460LFUCache;

import java.util.HashMap;

public class LFUCache {
    int capacity;
    int size;
    int minFreq;
    HashMap<Integer, ListNode> mapNodes;
    HashMap<Integer, DDLinkList> mapFreq;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        mapNodes = new HashMap<>();
        mapFreq = new HashMap<>();
        minFreq = 1;
    }

    public int get(int key) {
        if(!mapNodes.containsKey(key)) {
            System.out.println(-1);
            return -1;
        }
        ListNode node = mapNodes.get(key);
        updateNode(node);
        System.out.println(node.val);
        return node.val;
    }

    public void put(int key, int value) {
        if(capacity==0) return;
        ListNode node;
        if(mapNodes.containsKey(key)) {
            node = mapNodes.get(key);
            updateNode(node);
            node.val=value;
        } else {
            if(size==capacity) {
                size--;
                DDLinkList ddl = mapFreq.get(minFreq);
                ListNode tail = ddl.getTail();
                ddl.removeNode(tail);
                mapNodes.remove(tail.key);
                if(ddl.isEmpty()) {
                    mapFreq.remove(minFreq);
                }
            }
            size++;
            minFreq=1;
            node = new ListNode(key,value);
            DDLinkList ddl = mapFreq.getOrDefault(minFreq, new DDLinkList());
            ddl.addNode(node);
            mapFreq.put(minFreq,ddl);
            mapNodes.put(key,node);
        }
    }

    public void updateNode(ListNode node) {
        DDLinkList ddl = mapFreq.get(node.freq);
        ddl.removeNode(node);
        if (ddl.isEmpty()) {
            if(node.freq==minFreq) minFreq++;
            mapFreq.remove(node.freq);
        }
        node.freq++;
        ddl = mapFreq.getOrDefault(node.freq,new DDLinkList());
        ddl.addNode(node);
        mapFreq.put(node.freq,ddl);
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);
        cache.put(3,1);
        cache.put(2,1);
        cache.put(2,2);
        cache.put(4,4);
        cache.get(2);
        // 5 4 3 2
        }
}
