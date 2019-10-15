package LeetCode.Q34FindFirstandLastPositionOfElementInSortedArray;

import java.util.Arrays;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length-1;
        int[] coords = {-1,-1};
        searchRange(nums,target,lo,hi,coords);
        return coords;
    }
    public void searchRange(int[]nums, int target, int lo, int hi, int[] coords) {
        System.out.println(lo+", "+hi);
        if(lo>hi) {
            return;
        }
        int mid = lo + (hi-lo)/2;
        if(nums[mid]==target) {
            if(mid!=0 && nums[mid-1]==target) {
                searchRange(nums,target,lo,mid-1,coords);
            } else {
                coords[0]=mid;
            }
            if(mid!=nums.length-1 && nums[mid+1]==target) {
                searchRange(nums,target,mid+1,hi,coords);
            } else {
                coords[1]=mid;
            }
        } else if(target<nums[mid]) {
            searchRange(nums,target,lo,mid-1,coords);
        } else searchRange(nums,target,mid+1,hi,coords);
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        int[] coords = s.searchRange(nums, target);
        System.out.println(Arrays.toString(coords));;
    }
}
