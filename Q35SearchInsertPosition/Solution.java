package LeetCode.Q35SearchInsertPosition;

public class Solution {
    public int searchInsert(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length-1;
        while(lo<=hi) {
            System.out.println(lo+", "+hi);
            int mid = lo+(hi-lo)/2;
            if(target<=nums[mid]) {
                if(mid==0 || target>nums[mid-1]) {
                    return mid;
                } else {
                    hi=mid-1;
                }
            } else {
                if(mid==nums.length-1 || target<nums[mid+1]) {
                    return mid+1;
                } else {
                    lo = mid+1;
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int nums[] = {};
        int target = 4;
        System.out.println(s.searchInsert(nums,target));
    }
}
