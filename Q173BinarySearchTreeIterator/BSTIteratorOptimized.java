package LeetCode.Q173BinarySearchTreeIterator;

import LeetCode.Utility.*;

import java.util.Deque;
import java.util.LinkedList;

public class BSTIteratorOptimized {
    Deque<TreeNode> stack;

    public BSTIteratorOptimized(TreeNode root) {
        stack = new LinkedList<>();
        addLeftMost(root);
    }

    public void addLeftMost(TreeNode node) {
        if(node==null) return;

        while(node!=null) {
            stack.push(node);
            node=node.left;
        }
    }

    public int next() {
        if(stack.isEmpty()) return -1;
        TreeNode node = stack.pop();
        addLeftMost(node.right);
        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public static void main(String[] args) {
        TreeNode root = UsefulMethods.buildTree(1);
        BSTIteratorOptimized bst = new BSTIteratorOptimized(root);
        System.out.println(bst.stack);
        System.out.println(bst.next());
        System.out.println(bst.hasNext());
//        System.out.println(bst.next());
    }
}
