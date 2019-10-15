package LeetCode.Q198HouseRobber;

public class SolutionBottomUp {
    public int rob(int[] nums) {
        if(nums.length==0) return 0;

        int[] cache = new int[nums.length];
        cache[0]=nums[0];
        for (int i = 1; i < nums.length; i++) {
            int prev = i>1 ? cache[i-2] : 0;
            cache[i] = Math.max(cache[i-1],nums[i]+prev);
        }
        return cache[nums.length-1];
    }

    public static void main(String[] args) {
        SolutionBottomUp s = new SolutionBottomUp();
        int[] nums = {1,2,3,2,1};
        System.out.println(s.rob(nums));
    }
}
