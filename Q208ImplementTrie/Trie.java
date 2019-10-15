package LeetCode.Q208ImplementTrie;

public class Trie {
    class TrieNode {
        boolean isEnd;
        TrieNode[] next;
        public TrieNode() {
            isEnd=false;
            next = new TrieNode[26];
        }
    }

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for(char ch : word.toCharArray()) {
            int index = ch-'a';
            if(node.next[index]==null) node.next[index] = new TrieNode();
            node = node.next[index];
        }
        node.isEnd=true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for(char ch : word.toCharArray()) {
            node = node.next[ch-'a'];
            if(node==null) return false;
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(char ch : prefix.toCharArray()) {
            node = node.next[ch-'a'];
            if(node==null) return false;
        }
        return true;
    }
}
