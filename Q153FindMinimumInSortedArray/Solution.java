package LeetCode.Q153FindMinimumInSortedArray;

import LeetCode.Utility.*;

public class Solution {

    public int findMin(int[] nums) {
        if (nums==null || nums.length==0) return -1;
        int L = 0;
        int R = nums.length-1;
        while(L<R) {
            int mid = L + (R-L)/2;
            if(nums[mid]>nums[R])  L=mid+1;
            else R=mid;
        }
        return nums[L];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {2,1};
        System.out.println(s.findMin(nums));
    }
}
