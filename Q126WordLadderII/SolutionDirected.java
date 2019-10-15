package LeetCode.Q126WordLadderII;

import java.util.*;

public class SolutionDirected {

    public List<List<String>> findLadders(String start, String end, List<String> wordList) {
        int L = start.length();
        List<List<String>> results = new ArrayList<>();
        HashMap<String,List<String>> nodeNeighbors;
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

        nodeNeighbors=bfs(start,end,preprocess);
        if(nodeNeighbors==null) return results;
        dfs(start,end,nodeNeighbors,new ArrayList<>(),results);
        return results;
    }

    public List<String> getNeighbors(String word, HashMap<String, List<String>> preprocess) {
        char[] chars = word.toCharArray();
        List<String> res = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            char tmp = chars[i];
            chars[i] = '_';
            String key = String.valueOf(chars);
            if(preprocess.containsKey(key)) {
                List<String> neighbors = preprocess.get(key);
                for(String neighbor : neighbors) if(!neighbor.equals(word)) res.add(neighbor);
            }
            chars[i] = tmp;
        }
        return res;
    }

    public HashMap<String,List<String>> bfs(String start, String end, HashMap<String, List<String>> preprocess) {
        HashMap<String, List<String>> nodeNeighbors = new HashMap<>();
        HashMap<String, Integer> nodeDistance = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        int level = 1;
        nodeDistance.put(start, level);
        boolean foundEnd = false;
        while (!queue.isEmpty()) {
            int layerSize = queue.size();
            for (int i = 0; i < layerSize; i++) {
                String word = queue.poll();
                List<String> neighbors = getNeighbors(word, preprocess);
                nodeNeighbors.put(word, new ArrayList<>());
                for (String neighbor : neighbors) {
                    if (!nodeDistance.containsKey(neighbor) || level < nodeDistance.get(neighbor)) {
                        nodeNeighbors.get(word).add(neighbor);
                        nodeDistance.put(neighbor, level+1);
                        if (neighbor.equals(end)) foundEnd = true;
                        else queue.add(neighbor);
                    }
                }
            }
            level++;
            if(foundEnd) return nodeNeighbors;
        }
        return null;
    }

    public void dfs(String start, String end, HashMap<String,List<String>> nodeNeighbors, List<String> res, List<List<String>> result) {
        System.out.println(start);
        res.add(start);
        if (start.equals(end)) {
            result.add(new ArrayList<>(res));
        } else {
            if(nodeNeighbors.containsKey(start)) for (String word : nodeNeighbors.get(start)) {
                dfs(word, end, nodeNeighbors, res, result);
            }
        }
        res.remove(res.size() - 1);
    }

    public static void main(String[] args) {
        SolutionDirected s = new SolutionDirected();
        List<String> wordList;
        wordList = new ArrayList<>(Arrays.asList("most","mist","miss","lost","fist","fish"));
        System.out.println(s.findLadders("lost","must",wordList));
        wordList = new ArrayList<>(Arrays.asList("oar","sat","dip","sir","lap","tat","off","din","caw","hob","lie","tam","wyo","noe","rob","nay","hah","box","mac","low","tin","tip","set","geo","too","tea","fin","tad","zed","key","ray","shy","min","kin","rep","now","ink","fag","fed","pas","huh","bad","oks","pan","kip","inc","bat","pop","pat","aol","cud","tan","car","hut","oat","gap","hes","hen","chi"));
        System.out.println(s.findLadders("set","oar",wordList));
        wordList = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
        System.out.println(s.findLadders("hit","cog",wordList));
        wordList = new ArrayList<>(Arrays.asList("a","b","c"));
        System.out.println(s.findLadders("a","c",wordList));
        wordList = new ArrayList<>(Arrays.asList("ted","tex","red","tax","tad","den","rex","pee"));
        System.out.println(s.findLadders("red","tax",wordList));
    }
}

