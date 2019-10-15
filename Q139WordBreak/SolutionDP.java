package LeetCode.Q139WordBreak;

import java.util.Arrays;
import java.util.List;

public class SolutionDP {
    class TrieNode {
        String word;
        TrieNode[] next;

        public TrieNode() {
            next = new TrieNode[26];
        }
    }

    public TrieNode buildTrie(List<String> wordDict) {
        TrieNode root = new TrieNode();
        for (String word : wordDict) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                if (node.next[index] == null) node.next[index] = new TrieNode();
                node = node.next[index];
            }
            node.word = word;
        }
        return root;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        TrieNode root = buildTrie(wordDict);
        TrieNode node = root;
        boolean[] cache = new boolean[s.length()+1];
        cache[0] = true;

        for (int i = 0; i < s.length(); i++) {
            int j = i;
            if(!cache[i]) continue;
            node=root;
            while(j<s.length() && node.next[s.charAt(j)-'a']!=null) {
                node=node.next[s.charAt(j++)-'a'];
                if(node.word!=null) {
                    cache[j]=true;
                }
            }
        }
        return cache[s.length()];
    }

    public static void main(String[] args) {
        SolutionDP s = new SolutionDP();
        List<String> wordDict = Arrays.asList("cats","cat","and","sand","dogs");
        String sen = "catsandogs";
        System.out.println(s.wordBreak(sen,wordDict));
    }
}