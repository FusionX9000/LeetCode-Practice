package LeetCode.Q238ProductofArrayExceptSelf;

import LeetCode.Utility.*;

import java.util.Arrays;

public class Solution {

    public int[] productExceptSelf(int[] nums) {
        if(nums==null || nums.length<=1) return null;

        int[] pR = new int[nums.length];
        int[] pL = new int[nums.length];

        pL[0] = nums[0];
        pR[nums.length-1] = nums[nums.length-1];

        for (int i = 1; i < nums.length; i++) {
            pL[i] = pL[i-1]*nums[i];
        }

        for (int i = nums.length-2; i >= 0; i--) {
            pR[i] = pR[i+1]*nums[i];
        }

        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int left = i==0 ? 1 : pL[i-1];
            int right = i==nums.length-1 ? 1 : pR[i+1];
            result[i] = left*right;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(s.productExceptSelf(nums)));
    }
}
