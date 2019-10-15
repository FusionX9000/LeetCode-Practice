package LeetCode.Q456_132Pattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public boolean find132pattern(int[] nums) {
        if(nums.length==0) return false;
        int[] minI = new int[nums.length];
        minI[0]=nums[0];
        for (int i = 1; i < nums.length; i++) {
            minI[i] = Math.min(minI[i-1],nums[i]);
        }
        Deque<Integer> stack = new LinkedList<>();
        stack.push(nums[nums.length-1]);
        for (int j = nums.length-1; j >=1 ; j--) {
            if(nums[j]>minI[j]) {
                while(!stack.isEmpty() && stack.peek()<=minI[j]) {
                    stack.pop();
                }
                if(!stack.isEmpty() && stack.peek()<nums[j]) return true;
                stack.push(nums[j]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {3,1,4,2};
        System.out.println(s.find132pattern(nums));
        nums = new int[]{1, 2, 3, 4};
        System.out.println(s.find132pattern(nums));
        nums = new int[]{1,0,1,-4,-3};
        System.out.println(s.find132pattern(nums));
        nums = new int[]{3,5,0,3,4};
        System.out.println(s.find132pattern(nums));

    }
}
