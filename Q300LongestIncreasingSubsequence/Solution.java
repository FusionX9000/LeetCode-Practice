package LeetCode.Q300LongestIncreasingSubsequence;

import java.util.Arrays;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        int ans = lengthOfLIS(nums,0, 0, dp);
        for(int[] d : dp) System.out.println(Arrays.toString(d));
        return ans;
    }

    public int lengthOfLIS(int[] nums, int prev, int pos, int[][] dp) {
        if(pos==nums.length) return 0;
        int taken = 0;
        if(dp[pos][prev] > 0) return dp[pos][prev];
        if(prev==pos || nums[pos]>nums[prev]) {
            taken = 1+lengthOfLIS(nums,pos,pos+1, dp);
        }
        int nottaken = 0;
        if(prev==pos) nottaken = lengthOfLIS(nums,pos+1,pos+1,dp);
        else nottaken = lengthOfLIS(nums,prev,pos+1,dp);
        dp[pos][prev] = Math.max(taken,nottaken);
        return dp[pos][prev];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {10,9,2,5,3,7,101,18};
//        int[] nums = {1,3,6,7,9,4,10,5,6};
        System.out.println(s.lengthOfLIS(nums));
    }
}
