package LeetCode.Q213HouseRobberII;

public class SolutionOptimized {
    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];

        return Math.max(rob(nums,0,nums.length-1),rob(nums,1,nums.length));
    }
    public int rob(int[] nums, int start, int end) {
        int pprev = 0;
        int prev = 0;
        for (int i = start; i < end ; i++) {
            int tmp = prev;
            prev=Math.max(pprev+nums[i],prev);
            pprev=tmp;
        }
        return prev;
    }

    public static void main(String[] args) {
        SolutionOptimized s = new SolutionOptimized();
        int[] nums = {1,2,3,1};
        System.out.println(s.rob(nums));
    }
}