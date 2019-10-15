package LeetCode.Q198HouseRobber;

public class Solution {
    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        return rob(nums,0, new int[nums.length]);
    }

    public int rob(int[] nums, int pos, int[] cache) {
        if(pos>=nums.length) return 0;
        if(cache[pos]>0) return cache[pos];
        if(nums[pos]==0) cache[pos] = rob(nums,pos+1,cache);
        else cache[pos]=Math.max(nums[pos]+rob(nums,pos+2,cache),rob(nums,pos+1,cache));
        return cache[pos];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,2,3,2,1};
        System.out.println(s.rob(nums));
    }
}
