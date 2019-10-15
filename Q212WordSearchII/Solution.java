package LeetCode.Q212WordSearchII;

import java.util.*;

public class Solution {
    class TrieNode {
        String word;
        TrieNode[] children;

        public TrieNode() {
            children = new TrieNode[26];
        }

        public void addNode(char ch) {
            if (children[ch - 'a'] != null) return;
            children[ch - 'a'] = new TrieNode();
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> results = new ArrayList<>();
        if (board.length == 0 || board[0].length == 0 || words.length == 0) return new ArrayList<>();

        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                node.addNode(ch);
                node = node.children[ch - 'a'];
            }
            node.word = word;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, results);
            }
        }
        return results;
    }

    public void dfs(char[][] board, int row, int col, TrieNode node, List<String> results) {
        int R = board.length;
        int C = board[0].length;

        char ch = board[row][col];
        if(ch == '.' || node.children[ch - 'a'] == null) return;

        board[row][col] = '.';
        node = node.children[ch - 'a'];

        if (node.word!=null) {
            results.add(node.word);
            node.word=null;
        }

        if(row<R-1) dfs(board, row + 1, col, node, results);
        if(row>0) dfs(board, row - 1, col, node, results);
        if(col>0) dfs(board, row, col - 1, node, results);
        if(col< C-1) dfs(board, row, col + 1, node, results);

        board[row][col] = ch;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] words = {"oath", "pea", "eat", "rain"};
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        board = new char[][] {{'a','b'},{'a','a'}};
        words = new String[]{"aba","baa","bab","aaab","aaa","aaaa","aaba"};
        System.out.println(s.findWords(board,words));
    }

}
