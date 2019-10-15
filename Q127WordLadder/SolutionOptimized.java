package LeetCode.Q127WordLadder;

import java.util.*;

public class SolutionOptimized {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int result = 0;
        Map<String,List<String>> map = new HashMap<>();
        for(String word : wordList) {
            char[] chars = word.toCharArray();
            for(int i = 0; i<beginWord.length(); i++) {
                char tmp = chars[i];
                chars[i]='_';
                List<String> lst = map.getOrDefault(String.valueOf(chars),new ArrayList<>());
                lst.add(word);
                map.put(String.valueOf(chars),lst);
                chars[i]=tmp;
            }
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1,beginWord));
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            String word = node.val;
            int level = node.index;
            char[] chars = word.toCharArray();
            for(int i = 0; i<beginWord.length(); i++) {
                char tmp = chars[i];
                chars[i] = '_';
                for(String w : map.getOrDefault(String.valueOf(chars), new ArrayList<>())) {
                    if(w.equals(endWord)) return level+1;
                    if(!visited.contains(w)) {
                        queue.add(new Node(level+1,w));
                        visited.add(w);
                    }
                }
                chars[i] = tmp;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        SolutionOptimized s = new SolutionOptimized();
//        List<String> wordList = new ArrayList<>(Arrays.asList("hot","cog","tot","hog","hop","pot","dot","dog"));
        List<String> wordList = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log"));
        System.out.println(s.ladderLength("hit","cog",wordList));
    }
}