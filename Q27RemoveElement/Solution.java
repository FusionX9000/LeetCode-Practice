package LeetCode.Q27RemoveElement;

import java.util.Arrays;

public class Solution {
    public int removeElement(int[] nums, int val) {
        int last=nums.length;
        int i = 0;
        while(i<last) {
            if(nums[i]==val) {
                nums[i] = nums[--last];
            } else {
                i++;
            }
        }
        return last;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {0,1,2,2,3,0,4,2};
        System.out.println(Arrays.toString(nums));
        int length=s.removeElement(nums,2);
        System.out.println(Arrays.toString(Arrays.copyOf(nums,length)));
    }
}
