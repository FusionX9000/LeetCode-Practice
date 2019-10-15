package LeetCode.Q75SortColors;

import java.util.Arrays;

public class Solution {
    public void sortColors(int[] nums) {
        int lo = 0;
        int i = 0;
        int hi = nums.length-1;
        int mid = 1;
        while(i<=hi) {
            if(nums[i]<mid) {
                int tmp = nums[i];
                nums[i] = nums[lo];
                nums[lo] = tmp;
                lo++;
                i++;
            } else if(nums[i]>mid) {
                int tmp = nums[i];
                nums[i] = nums[hi];
                nums[hi] = tmp;
                hi--;
            } else i++;
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {2,0,2,1,1,0,0,0,1,0};
        s.sortColors(nums);
    }
}
