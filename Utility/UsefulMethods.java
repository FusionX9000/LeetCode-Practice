package LeetCode.Utility;

import java.util.*;

public final class UsefulMethods {
    private UsefulMethods() {
    }

    public static void printListNode(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " --> ");
            node = node.next;
        }
        System.out.print("null\n");
    }

    public static void print(Object... objs) {
        for (Object obj : objs) {
            System.out.print(obj);
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void print(Object obj, Integer...margins) {
        int margin = margins.length>0 ? margins[0] : 5;

        if (obj instanceof List) {
            List lst = (List) obj;
            separator(lst.size()*margin);
            for (Object l : lst) print(l);
        } else if(obj instanceof String) prettyprint(obj,margin);
        else System.out.println(obj);
    }

    public static void prettyprint(Object ob, int margin) {

        if(ob instanceof String) {
            System.out.println(Arrays.toString(((String) ob).toCharArray()));
            return;
        }

        List lst = (List)ob;
        if(lst.size()==0) return;
        char type;

        if(lst.get(0) instanceof String) type='s';
        else if(lst.get(0) instanceof Integer) type='d';
        else type='f';

        System.out.print("[");
        for(Object obj : lst) {
            if (type=='f') System.out.printf("%"+margin+".4f, ",obj);
            else System.out.printf("%"+margin+type+", ",obj);
        }
        System.out.print("]\n");
    }

    private static void separator(int n) {
        for(int i = 0; i<n; i++) {
            System.out.print("=");
        }
        System.out.println();
    }

//    public static TreeNode buildTree(Integer ...nums) {
//        if(nums.length==0 || nums[0]==null) return null;
//
//        int i = 0;
//        TreeNode root = new TreeNode(nums[i++]);
//
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//
//        while(!queue.isEmpty() && i<nums.length) {
//            int queueSize = queue.size();
//            for (int j = 0; j < queueSize; j++) {
//                TreeNode node = queue.poll();
//
//                if(node==null) continue;
//
//                Integer left = nums[i++];
//                node.left= left!=null ? new TreeNode(left) : null;
//
//                if(i==nums.length) break;
//
//                Integer right = nums[i++];
//                node.right= right!=null ? new TreeNode(right) : null;
//
//                queue.add(node.left);
//                queue.add(node.right);
//            }
//        }
//
//        return root;
//    }

    public static TreeNode buildTree(Integer ...nodes) {
        return buildTree(nodes, 0);
    }

    public static TreeNode buildTree(Integer[] nodes, int i) {
        if(i>=nodes.length) return null;
        Integer val = nodes[i];
        if(val==null) return null;
        TreeNode root = new TreeNode(val);
        root.left = buildTree(nodes,2*i+1);
        root.right = buildTree(nodes,2*i+2);
        return root;
    }

    public static void printTree(TreeNode root) {
        if(root==null) {
            System.out.println("null");
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        StringJoiner result = new StringJoiner(", ");


        while(!queue.isEmpty()) {
            int layerSize = queue.size();

            boolean lastLayer = true;
            StringJoiner curr = new StringJoiner(", ");

            for (int i = 0; i < layerSize; i++) {
                TreeNode node = queue.poll();
                if(node==null) {
                    curr.add("null");
                } else {
                    lastLayer=false;
                    curr.add(String.valueOf(node.val));
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            if(!lastLayer) result.add(curr.toString());
        }
        System.out.println(result.toString());
    }
}
