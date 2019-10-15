package LeetCode.Q337HouseRobberIII;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    class Node {
        int include;
        int exclude;

        public Node(){
            include=0;
            exclude=0;
        }

        public int getMax() {return Math.max(include,exclude);}
    }

    public int rob(TreeNode root) {
        return robNode(root).getMax();
    }

    public Node robNode(TreeNode root) {
        Node node = new Node();

        if(root==null) return node;

        Node rnode = robNode(root.left);
        Node lnode = robNode(root.right);

        node.include = root.val + rnode.exclude + lnode.exclude;
        node.exclude = Math.max(rnode.include,rnode.exclude) + Math.max(lnode.include,lnode.exclude);

        return node;
    }


    public TreeNode buildTree(Integer[] nums) {
        if(nums.length==0 || nums[0]==null) return null;

        int i = 0;
        TreeNode root = new TreeNode(nums[i++]);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty() && i<nums.length) {
            int queueSize = queue.size();
            for (int j = 0; j < queueSize; j++) {
                TreeNode node = queue.poll();

                if(node==null) continue;

                Integer left = nums[i++];
                node.left= left!=null ? new TreeNode(left) : null;

                if(i==nums.length) break;

                Integer right = nums[i++];
                node.right= right!=null ? new TreeNode(right) : null;

                queue.add(node.left);
                queue.add(node.right);
            }
        }

        return root;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Integer[] nums = {4,1,null,2,null,3};
        TreeNode root = s.buildTree(nums);
        System.out.println(s.rob(root));
    }
}
