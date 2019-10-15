package LeetCode.Q127WordLadder;

import java.util.*;

public class SolutionBiDirectional {
    int L;
    Map<String,List<String>> map;
    public SolutionBiDirectional() {
        L = 0;
        map = new HashMap<>();
    }
    public Integer visitWordNode(Queue<Node> queue, HashMap<String,Integer> visited1, HashMap<String,Integer> visited2) {
        Node node = queue.poll();
        String word = node.val;
        int level = node.index;
        char[] chars = word.toCharArray();
        for(int i = 0; i<L; i++) {
            char tmp = chars[i];
            chars[i] = '_';
            for(String w : map.getOrDefault(String.valueOf(chars), new ArrayList<>())) {
                if(!visited1.containsKey(w)) {
                    if(visited2.containsKey(w)) return level+visited2.get(w);
                    queue.add(new Node(level+1,w));
                    visited1.put(w,level+1);
                }
            }
            chars[i] = tmp;
        }
        return null;
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        L = beginWord.length();
        for(String word : wordList) {
            char[] chars = word.toCharArray();
            for(int i = 0; i<L; i++) {
                char tmp = chars[i];
                chars[i]='_';
                List<String> lst = map.getOrDefault(String.valueOf(chars),new ArrayList<>());
                lst.add(word);
                map.put(String.valueOf(chars),lst);
                chars[i]=tmp;
            }
        }

        Queue<Node> queue_one = new LinkedList<>();
        queue_one.add(new Node(1,beginWord));
        HashMap<String,Integer> visited1 = new HashMap<>();
        visited1.put(beginWord,1);
        Queue<Node> queue_two = new LinkedList<>();
        queue_two.add(new Node(1,endWord));
        HashMap<String,Integer> visited2 = new HashMap<>();
        visited2.put(endWord,1);

        while(!queue_one.isEmpty() && !queue_two.isEmpty()) {
            Integer result = visitWordNode(queue_one,visited1,visited2);
            if(result!=null) return result;
            result = visitWordNode(queue_two,visited2,visited1);
            if(result!=null) return result;
        }
        return 0;
    }

    public static void main(String[] args) {
        SolutionBiDirectional s = new SolutionBiDirectional();
        List<String> wordList = new ArrayList<>(Arrays.asList("hot","cog","tot","hog","hop","pot","dot","dog"));
//        List<String> wordList = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log"));
        System.out.println(s.ladderLength("hit","cog",wordList));
    }
}

