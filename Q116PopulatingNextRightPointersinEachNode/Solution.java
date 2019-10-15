package LeetCode.Q116PopulatingNextRightPointersinEachNode;

import LeetCode.Utility.*;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public Node connect(Node root) {
        if(root==null) return root;
        Deque<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node prev = null;
            int layerSize = queue.size();
            for (int i = 0; i < layerSize; i++) {
                Node node = queue.poll();
                node.next = prev;
                prev = node;

                Node nl = node.left;
                Node nr = node.right;

                boolean lastLayer = nl == null || nr == null;

                if (!lastLayer) {
                    queue.add(nr);
                    queue.add(nl);
                }
            }
            System.out.println(queue);
        }
        return root;
    }
}
