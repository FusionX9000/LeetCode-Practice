package LeetCode.Q124BinaryTreeMaximumPathSum;

import LeetCode.Utility.*;

public class Solution {

    int globalMax=Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return globalMax;
    }

    private int helper(TreeNode root) {
        if(root==null) return 0;

        int maxLeft = Math.max(0,helper(root.left));
        int maxRight = Math.max(0,helper(root.right));

        int maxSum = root.val+Math.max(maxLeft,maxRight);

        this.globalMax = Math.max(this.globalMax,root.val+maxLeft+maxRight);

        return maxSum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = UsefulMethods.buildTree(1,2,3);

        System.out.println(s.maxPathSum(root));
    }
}
