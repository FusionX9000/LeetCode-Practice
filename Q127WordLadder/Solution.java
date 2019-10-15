package LeetCode.Q127WordLadder;

import java.util.*;

public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        List<List<Node>> adj = new ArrayList<>();
        List<Node> nodes = new ArrayList<>();

//        if(!wordList.contains(endWord)) return 0;

        for (int i = 0; i < wordList.size(); i++) {
            nodes.add(new Node(i,wordList.get(i)));
        }
        int result = Integer.MAX_VALUE;

        for(int i = 0; i<wordList.size(); i++) {
            adj.add(new ArrayList<>());
            for(int j = 0; j<wordList.size(); j++) {
                if(i!=j && wordDistance(wordList.get(i),wordList.get(j))==1) {
                    adj.get(i).add(nodes.get(j));
                }
            }
        }

        for (int i = 0; i < wordList.size(); i++) {
            int wd = wordDistance(beginWord,wordList.get(i));
            if(wd==1) {
//                System.out.println(wordList.get(i));
                int res = bfs(adj,nodes.get(i),endWord);
//                System.out.println(res);
                if(res==0) return 0;
                result = Math.min(result,res);
            }
        }
        return result == Integer.MAX_VALUE ? 0 : ++result;
    }

    public int bfs(List<List<Node>> adj, Node start, String endWord) {
        int count=1;
        Queue<Node> queue = new LinkedList<>();
        boolean[] seen = new boolean[adj.size()];
        queue.add(start);
        seen[start.index] = true;
        while(!queue.isEmpty()) {
//            System.out.println(queue);
            int layerSize = queue.size();
            for(int layer = 0; layer<layerSize; layer++) {
                Node node = queue.poll();
                if (node.val.equals(endWord)) return count;
                for (Node child : adj.get(node.index)) {
                    if (!seen[child.index]) {
                        queue.add(child);
                        seen[child.index] = true;
                    }
                }
            }
            count++;
        }
        return Integer.MAX_VALUE;
    }


    public int wordDistance(String a, String b) {
        int result = 0;
        for (int i = 0; i < a.length(); i++) {
            if(a.charAt(i)!=b.charAt(i)) result++;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> wordList = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
        System.out.println(s.ladderLength("hit","cog",wordList));
        List<String> wordList2 = new ArrayList<>(Arrays.asList("hot","cog","tot","hog","hop","pot","dot"));
        System.out.println(s.ladderLength("hot","dog",wordList2));

    }

}
