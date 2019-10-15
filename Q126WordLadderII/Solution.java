package LeetCode.Q126WordLadderII;

import LeetCode.Q460LFUCache.LFUCache;

import java.util.*;

public class Solution {

    public List<List<String>> findLadders(String start, String end, List<String> wordList) {
        int L = start.length();
        List<List<String>> results = new ArrayList<>();
        HashMap<String,List<String>> nodeNeighbors = new HashMap<>();
        HashMap<String,Integer> nodeDistance = new HashMap<>();
        HashMap<String,List<String>> preprocess = new HashMap<>();

        for(String word : wordList) {
            char[] chars = word.toCharArray();
            for(int i = 0; i<L; i++) {
                char tmp = chars[i];
                chars[i] = '_';
                preprocess.computeIfAbsent(String.valueOf(chars),z->new ArrayList<>()).add(word);
                chars[i] = tmp;
            }
        }

        bfs(start,end,preprocess,nodeNeighbors,nodeDistance);
        dfs(start,end,nodeNeighbors,nodeDistance,new ArrayList<>(),results);
        return results;
    }

    public void getNeighbors(String word, HashMap<String, List<String>> preprocess, HashMap<String,List<String>> nodeNeighbors) {
        char[] chars = word.toCharArray();
        nodeNeighbors.put(word, new ArrayList<>());
        for (int i = 0; i < word.length(); i++) {
            char tmp = chars[i];
            chars[i] = '_';
            String key = String.valueOf(chars);
            if(preprocess.containsKey(key)) {
                List<String> neighbors = preprocess.get(key);
                for(String neighbor : neighbors) if(!neighbor.equals(word)) nodeNeighbors.get(word).add(neighbor);
            }
            chars[i] = tmp;
        }
    }

    public void bfs(String start, String end, HashMap<String, List<String>> preprocess, HashMap<String,List<String>> nodeNeighbors, HashMap<String,Integer> nodeDistance) {
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        int level = 1;
        nodeDistance.put(start,level);
        while(!queue.isEmpty()) {
            level++;
            int layerSize = queue.size();
            for (int i = 0; i < layerSize; i++) {
                String word = queue.poll();
                getNeighbors(word,preprocess,nodeNeighbors);
                for(String neighbor : nodeNeighbors.get(word)) {
                    if(!nodeDistance.containsKey(neighbor)) {
                        if(word.equals(end)) break;
                        queue.add(neighbor);
                        nodeDistance.put(neighbor,level);
                    }
                }
            }
        }
    }

    public void dfs(String start, String end, HashMap<String,List<String>> nodeNeighbors, HashMap<String,Integer> nodeDistance, List<String> res, List<List<String>> result) {
        res.add(start);
        if (start.equals(end)) {
            result.add(new ArrayList<>(res));
        } else {
            for (String word : nodeNeighbors.get(start)) {
                if (nodeDistance.get(start) + 1 == nodeDistance.get(word)) {
                    dfs(word, end, nodeNeighbors, nodeDistance, res, result);
                }
            }
        }
        res.remove(res.size() - 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> wordList;
        wordList = new ArrayList<>(Arrays.asList("most","mist","miss","lost","fist","fish"));
        wordList = new ArrayList<>(Arrays.asList("oar","sat","dip","sir","lap","tat","off","din","caw","hob","lie","tam","wyo","noe","rob","nay","hah","box","mac","low","tin","tip","set","geo","too","tea","fin","tad","zed","key","ray","shy","min","kin","rep","now","ink","fag","fed","pas","huh","bad","oks","pan","kip","inc","bat","pop","pat","aol","cud","tan","car","hut","oat","gap","hes","hen","chi"));
        System.out.println(s.findLadders("set","oar",wordList));
        wordList = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
        System.out.println(s.findLadders("hit","cog",wordList));
    }
}
