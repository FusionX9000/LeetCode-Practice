package LeetCode.Q31NextPermutation;

// 9 8 5 4 2 1

import java.util.Arrays;

public class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length==0 || nums.length == 1) return;
        int index = firstDecreasingIndex(nums);
        if(index==-1) {
            reverse(nums,0);
            return;
        }
        int i = 0;
        for(i = index+1; i<nums.length && nums[i]>nums[index];i++);
        int temp = nums[index];
        temp = nums[i-1];
        nums[i-1] = nums[index];
        nums[index] = temp;
        reverse(nums,index+1);

    }
    public int firstDecreasingIndex(int[] nums) {
        for(int i = nums.length-2; i>=0; i--) {
            if(nums[i]<nums[i+1]) {
                return i;
            }
        }
        return -1;
    }
    public void reverse(int[] nums, int index) {
        if(index>=nums.length-1) return;
        int i = index;
        int j = nums.length-1;
        while(i<j) {
            int tmp = nums[i];
            nums[i]=nums[j];
            nums[j]=tmp;
            i++;
            j--;
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,3,2};
        s.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
