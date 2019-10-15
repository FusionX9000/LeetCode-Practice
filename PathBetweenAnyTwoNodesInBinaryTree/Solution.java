package LeetCode.PathBetweenAnyTwoNodesInBinaryTree;

import java.util.ArrayList;
import java.util.List;
import LeetCode.Utility.*;

public class Solution {
    private List<Integer> pathA;
    private List<Integer> pathB;
    private boolean pathFound=false;

    public List<Integer> pathBetween(TreeNode root,int a, int b) {
        List<Integer> result = new ArrayList<>();

        dfs(root,a,b,new ArrayList<>());
        if(!pathFound) return result;

        int intersection = findIntersection(pathA,pathB);

        for (int i = pathA.size()-1; i > intersection; i--) {
            result.add(pathA.get(i));
        }

        result.add(pathA.get(intersection));

        for (int i = intersection+1; i < pathB.size(); i++) {
            result.add(pathB.get(i));
        }
        return result;
    }

    public void dfs(TreeNode root, int a, int b, List<Integer> path) {
        if(pathA!=null && pathB!=null) pathFound=true;
        if(root==null || pathFound) return;

        path.add(root.val);

        if(pathA==null && root.val==a) pathA = new ArrayList<>(path);
        else if(root.val==b) pathB=new ArrayList<>(path);

        dfs(root.left, a, b, path);
        dfs(root.right, a, b, path);

        path.remove(path.size()-1);
    }

    private int findIntersection(List<Integer> pathA, List<Integer> pathB) {
        int intersection=-1;
        int i=0;

        while(i<pathA.size() && i<pathB.size()) {
            intersection=i;
            if(pathA.get(i).equals(pathB.get(i))) {
                i++;
            } else {
                intersection=i-1;
                break;
            }
        }
        return intersection;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = UsefulMethods.buildTree(0,1,2,3,4,5,6,7,null,8,9,0);
        System.out.println(s.pathBetween(root,7,3));
    }
}
