package LeetCode.Q863AllNodesDistanceKBinaryTree;

import java.util.*;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    public TreeNode(int data) {
        this.data = data;
    }
}
public class Solution {
    public void printQueue(Queue<TreeNode> queue) {
        for(TreeNode n: queue) {
            System.out.print(n.data+", ");
        }
        System.out.println();
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        buildMapOfParents(map,root,null);
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        queue.add(target);
        visited.add(target);
        while(!queue.isEmpty() && K>=0) {
            printQueue(queue);
            if(K==0) break;
            Queue<TreeNode> parents = queue;
            queue = new LinkedList<>();
            for(TreeNode n : parents){
                if(map.get(n)!=null && !visited.contains(map.get(n))) {
                    visited.add(map.get(n));
                    queue.add(map.get(n));
                }
                if(n.left!=null && !visited.contains(n.left)) {
                    visited.add(n.left);
                    queue.add(n.left);
                }
                if(n.right!=null && !visited.contains(n.right)) {
                    visited.add(n.right);
                    queue.add(n.right);
                }
            }
            K--;
        }
        List<Integer> result = new ArrayList<>();
        for(TreeNode n : queue) {
            result.add(n.data);
        }
        return K==0 ? result : null;
    }
    public void buildMapOfParents(Map<TreeNode, TreeNode> map, TreeNode root, TreeNode parent) {
        if(root==null) {
            return;
        }
        map.put(root,parent);
        buildMapOfParents(map,root.left,root);
        buildMapOfParents(map,root.right,root);
    }
    public List<TreeNode> getAdjacent(Map<TreeNode,TreeNode> map,TreeNode n) {
        if(n==null) {
            return null;
        }
        List<TreeNode> res = new ArrayList<>();
        if(n.left!=null) res.add(n.left);
        if(n.right!=null) res.add(n.right);
        if(map.get(n)!=null) res.add(map.get(n));
        return res;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(3);
        root.left= new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.right = new TreeNode(8);
        root.right.left = new TreeNode(0);
        List<Integer> result = s.distanceK(root,root.left,1);
        System.out.println(result.toString());
    }
}
