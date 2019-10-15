package LeetCode.Q39CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        backtrack(candidates,target,0,results,new ArrayList<Integer>());
        return results;
    }
    public void backtrack(int[] candidates, int target, int ptr, List<List<Integer>> results, List<Integer> result) {
        if (target==0) {
            results.add(new ArrayList<Integer>(result));
            return;
        } else if (ptr >= candidates.length || target<0) return;
        backtrack(candidates, target, ptr + 1, results, result);
        result.add(candidates[ptr]);
        backtrack(candidates, target - candidates[ptr], ptr, results, result);
        result.remove(result.size() - 1);
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> results = s.combinationSum(candidates,target);
        for(List<Integer> result : results) {
            System.out.println(result.toString());
        }
    }
}
