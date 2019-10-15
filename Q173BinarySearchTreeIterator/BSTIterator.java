package LeetCode.Q173BinarySearchTreeIterator;

import LeetCode.Utility.*;

import java.util.Deque;
import java.util.LinkedList;

public class BSTIterator {
    Deque<TreeNode> nodeParent;
    TreeNode next;
    int height;

    public BSTIterator(TreeNode root) {
        nodeParent = new LinkedList<>();
        height = 0;
        next = getLeftMost(root);
    }

    public int next() {
        TreeNode node = next;
        if(next.right!=null) {
            next = getLeftMost(next.right);
        } else if(!nodeParent.isEmpty()){
            TreeNode parent = nodeParent.peek();
            while(parent!=null && next!=parent.left) {
                next=nodeParent.pop();
                parent=nodeParent.peek();
            }
            next=nodeParent.pop();
        } else next=null;
        return node.val;
    }

    public TreeNode getLeftMost(TreeNode node) {
        if (node == null) return node;
        while (node.left != null) {
            nodeParent.push(node);
            node = node.left;
        }
        return node;
    }

    public boolean hasNext() {
        return next!=null;
    }

    public static void main(String[] args) {
        BSTIterator bst = new BSTIterator(UsefulMethods.buildTree(2,1));
        System.out.println(bst.hasNext());
        System.out.println(bst.next());
        System.out.println(bst.hasNext());
        System.out.println(bst.next());
        System.out.println(bst.hasNext());
//        System.out.println(bst.next());
//        System.out.println(bst.hasNext());
    }
}
