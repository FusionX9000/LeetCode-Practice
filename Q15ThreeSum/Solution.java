package LeetCode.Q15ThreeSum;

import java.util.ArrayList;
import java.util.List;

//HIGHLY INEFFICIENT SOLUTION!

public class Solution {
    public void threeSum(int[] nums, List<List<Integer>> results, List<Integer> result, int sum, int pos, int left) {
//        System.out.println(result.toString()+", sum: "+sum+", left: "+left);
//        System.out.println(results.toString());
        if (pos == nums.length) {
            return;
        }
        if (left == 0) {
            if (sum==0) {
                if(results.contains(result)) {
                    return;
                }
                results.add(new ArrayList<Integer>(result));
            }
            return;
        }
        result.add(nums[pos]);
        threeSum(nums, results, result, sum+nums[pos], pos + 1, left-1);
        result.remove(result.size() - 1);
        threeSum(nums, results, result, sum, pos + 1, left);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        threeSum(nums, results, new ArrayList<Integer>(), 0, 0, 3);
        return results;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[] {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> results = s.threeSum(nums);
        for(List<Integer> result : results) {
            System.out.println(result.toString());
        }

    }
}
