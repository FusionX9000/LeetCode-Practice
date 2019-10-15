package LeetCode.Q53MaximumSubArray;

public class Solution {
    public int maxSubArray(int[] nums) {
        int currSum = 0;
        int maxSum = nums[0];
        for(int i = 0; i<nums.length; i++) {
            currSum = Math.max(nums[i],currSum+nums[i]);
            maxSum = Math.max(currSum,maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(s.maxSubArray(nums));
    }
}
