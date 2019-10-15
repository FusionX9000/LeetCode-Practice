package LeetCode.Q18FourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();
        for(int i = 0; i<nums.length-3; i++) {
            if ((i == 0 || nums[i] != nums[i - 1])) {
                for(List<Integer> result : threeSum(nums, i+1,target-nums[i])) {
                    result.add(nums[i]);
                    results.add(result);
                }
            }
        }
        return results;
    }
    public List<List<Integer>> threeSum(int[] nums, int pos, int target) {
        List<List<Integer>> results = new ArrayList<>();
        for(int i = pos; i<nums.length-2; i++) {
            if((i==pos || nums[i]!=nums[i-1]) ) {
                int l = i+1;
                int r = nums.length-1;
                while(l<r) {
                    if (nums[i] + nums[l] + nums[r] == target) {
                        List<Integer> result = new ArrayList<>(Arrays.asList(nums[i], nums[l], nums[r]));
                        System.out.println(result);
                        results.add(result);
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        l++;
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        r--;
                    } else if (nums[i] + nums[l] + nums[r] > target) {
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        r--;
                    } else {
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        l++;
                    }
                }
            }
        }
        return results;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,-2,-5,-4,-3,3,3,5};
        for(List<Integer> result : s.fourSum(nums,-11)) {
            System.out.println(result.toString());
        }
    }
}
