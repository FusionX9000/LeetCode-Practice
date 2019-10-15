package LeetCode.Q55JumpGame;

import java.util.Arrays;

import static LeetCode.Utility.UsefulMethods.print;

public class Solution {
    int count = 0;
    public boolean canJump(int[] nums) {
        Boolean[] dp = new Boolean[nums.length];
        dp[nums.length-1]=true;
        return canJump(nums,0, dp);
    }

    public boolean canJump(int[] nums, int pos, Boolean[] dp) {
        count++;
        System.out.println(pos);

        if(dp[pos]!=null) return dp[pos];
        dp[pos] = false;
        int farthestjump = Math.min(nums[pos]+pos,nums.length-1);
        for(int nextpos = farthestjump; nextpos>pos; nextpos--) {
            if(canJump(nums,nextpos,dp)) {
                dp[pos] = true;
                break;
            }
        }

        return dp[pos];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {3,2,1,0,4};
        int[] nums2= {2,3,1,1,4};
//        print(Arrays.toString(nums),s.canJump(nums));
        print(Arrays.toString(nums2),s.canJump(nums2));
        System.out.println(s.count);

    }
}
