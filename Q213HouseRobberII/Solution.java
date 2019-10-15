package LeetCode.Q213HouseRobberII;

import java.util.Arrays;

public class Solution {
    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        return Math.max(rob(nums,0, new int[nums.length],false),rob(nums,1, new int[nums.length],true));
    }

    public int rob(int[] nums, int pos, int[] cache, boolean includeEnd) {
        if(pos>=nums.length) return 0;
        if(pos==nums.length-1 && !includeEnd) return 0;
        if(cache[pos]>0) return cache[pos];
        if(nums[pos]==0) cache[pos] = rob(nums,pos+1,cache,includeEnd);
        else cache[pos]=Math.max(nums[pos]+rob(nums,pos+2,cache,includeEnd),rob(nums,pos+1,cache,includeEnd));
        return cache[pos];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,3,1,3,100};
        System.out.println(s.rob(nums));
    }
}
