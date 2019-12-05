package LeetCode.Q238ProductofArrayExceptSelf;

import LeetCode.Utility.*;

import java.util.Arrays;

public class SolutionN {

    public int[] productExceptSelf(int[] nums) {
        if(nums==null || nums.length<=1) return null;

        int[] result = new int[nums.length];
        result[nums.length-1] = nums[nums.length-1];


        for (int i = nums.length-2; i >= 0; i--) {
            result[i] = result[i+1]*nums[i];
        }

        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i-1]*nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            int left = i==0 ? 1 : nums[i-1];
            int right = i==nums.length-1 ? 1 : result[i+1];

            result[i] = left*right;
        }
        return result;
    }

    public static void main(String[] args) {
        SolutionN s = new SolutionN();
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(s.productExceptSelf(nums)));

    }
}
