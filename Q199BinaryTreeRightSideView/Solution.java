package LeetCode.Q199BinaryTreeRightSideView;

import java.util.*;

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int ls = queue.size();
            for (int i = 0; i < ls; i++) {
                TreeNode node = queue.poll();
                if(i==ls-1) result.add(node.val);
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
        }
        return result;

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
        Integer[] nums = {1,2};
        System.out.println(s.rightSideView(s.buildTree(nums)));
    }
}
