package LeetCode.Q26RemoveDuplicatesSortedArray;

import java.util.Arrays;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int p = 0;
        for(int i = 1; i<nums.length; i++) {
            if(nums[p]!=nums[i]) {
                p++;
            }
            nums[p]=nums[i];
        }
        return p+1;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(Arrays.toString(nums));
        System.out.println(s.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}
