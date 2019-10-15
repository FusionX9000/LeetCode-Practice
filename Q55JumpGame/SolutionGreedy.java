package LeetCode.Q55JumpGame;

public class SolutionGreedy {
    public boolean canJump(int[] nums) {
        int lastGood = nums.length-1;
        for(int i = nums.length-2; i>=0; i--) {
            if(nums[i]+i>=lastGood) lastGood = i;
        }
        return lastGood==0;
    }

    public static void main(String[] args) {
        SolutionGreedy s = new SolutionGreedy();
        int[] nums = {3,2,1,0,4};
        int[] nums2= {2,3,1,1,4};
        System.out.println(s.canJump(nums2));
    }
}
