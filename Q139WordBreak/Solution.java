package LeetCode.Q139WordBreak;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    class TrieNode {
        String word;
        TrieNode[] next;
        public TrieNode() {
            next = new TrieNode[26];
        }

    }

    public TrieNode buildTrie(List<String> wordDict) {
        TrieNode root = new TrieNode();

        for(String word : wordDict) {
            TrieNode node = root;
            for(char ch : word.toCharArray()) {
                int index = ch-'a';
                if(node.next[index]==null) node.next[index] = new TrieNode();
                node = node.next[index];
            }
            node.word=word;
        }
        return root;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.length()==0 || wordDict.size()==0) return false;
        TrieNode root = buildTrie(wordDict);
        Boolean[] cache = new Boolean[s.length()+1];
        cache[s.length()] = true;
        return helper(s.toCharArray(),0,root,cache);
    }

    public boolean helper(char[] sChars, int pos, TrieNode root, Boolean[] cache) {
        if(pos==sChars.length) return true;
        if(cache[pos]!=null) return cache[pos];
        cache[pos]=false;
        TrieNode node = root;
        for(int i = pos; i<sChars.length; i++) {
            char ch = sChars[i];
            int index = ch - 'a';
            node=node.next[index];
            if(node==null) {
                break;
            }
            if(node.word!=null && helper(sChars,i+1,root,cache)) {
                cache[pos]=true;
                break;
            }
        }
        return cache[pos];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> wordDict = Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");
        String sen = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        System.out.println(sen.length());
        System.out.println(s.wordBreak(sen,wordDict));
    }
}
