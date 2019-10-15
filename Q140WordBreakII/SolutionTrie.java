package LeetCode.Q140WordBreakII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SolutionTrie {
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

    HashMap<Integer,List<String>> cache = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        cache.put(s.length(),new ArrayList<>());
        cache.get(s.length()).add("");

        TrieNode root = buildTrie(wordDict);
        return wordBreak(s.toCharArray(),0,root);
    }

    public List<String> wordBreak(char[] s, int pos, TrieNode root) {
        List<String> result = new ArrayList<>();
        if(cache.containsKey(pos)) return cache.get(pos);
        TrieNode node = root;
        for (int i = pos; i < s.length; i++) {
            int index = s[i]-'a';
            node = node.next[index];
            if(node==null) break;

            if(node.word!=null) {
                List<String> rest = wordBreak(s,i+1,root);
                for(String sentence : rest) {
                    result.add(node.word + (sentence.isEmpty() ? "" : " ") + sentence);
                }
            }
        }
        cache.put(pos,result);
        return result;
    }

    public static void main(String[] args) {
        SolutionTrie s = new SolutionTrie();
        List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
        String sen = "catsanddog";
        System.out.println(sen.length());
        System.out.println(s.wordBreak(sen, wordDict));
    }
}
