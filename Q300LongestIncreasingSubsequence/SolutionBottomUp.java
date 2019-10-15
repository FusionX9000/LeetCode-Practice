package LeetCode.Q300LongestIncreasingSubsequence;

public class SolutionBottomUp {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int [nums.length];
        dp[0] = 1;
        int maxans = 1;
        for(int i = 1; i<nums.length; i++) {
            int maxval = 0;
            for(int j = 0; j<i; j++) {
                if(nums[j]<nums[i] && dp[j]>maxval) {
                    maxval=dp[j];
                }
            }
            dp[i]=maxval+1;
            maxans = Math.max(maxans,dp[i]);
        }
        return maxans;
    }

    public static void main(String[] args) {
        SolutionBottomUp s = new SolutionBottomUp();
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(s.lengthOfLIS(nums));
        int[] nums2 = {1,3,6,7,9,4,10,5,6};
        System.out.println(s.lengthOfLIS(nums2));
    }

}
