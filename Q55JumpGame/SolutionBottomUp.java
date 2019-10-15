package LeetCode.Q55JumpGame;

public class SolutionBottomUp {
    public boolean canJump(int[] nums) {
        Boolean[] dp = new Boolean[nums.length];
        dp[nums.length-1]=true;
        for(int i = nums.length-2; i>=0; i--) {
            int farthestjump = Math.min(nums[i]+i,nums.length-1);
            for(int j = farthestjump; j>=i+1; j--) {
                if(dp[j]!=null && dp[j]) {
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[0]!=null && dp[0];
    }

    public static void main(String[] args) {
        SolutionBottomUp s = new SolutionBottomUp();
        int[] nums = {3,2,1,0,4};
        int[] nums2= {2,3,1,1,4};
        System.out.println(s.canJump(nums2));
    }
}
