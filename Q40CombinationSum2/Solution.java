package LeetCode.Q40CombinationSum2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates,target,0,results,new ArrayList<Integer>());
        return results;
    }
    public void backtrack(int[] candidates, int target, int ptr, List<List<Integer>> results, List<Integer> result) {
        if (target == 0) {
            results.add(new ArrayList<Integer>(result));
            return;
        } else if (ptr >= candidates.length || target < 0) return;
        for (int i = ptr; i < candidates.length; i++) {
            if(i>ptr && candidates[i]==candidates[i-1]) continue;
            result.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i + 1, results, result);
            result.remove(result.size() - 1);
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> results = s.combinationSum2(candidates,target);
        for(List<Integer> result : results) {
            System.out.println(result.toString());
        }
    }
}
