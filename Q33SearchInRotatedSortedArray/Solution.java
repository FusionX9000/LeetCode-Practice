package LeetCode.Q33SearchInRotatedSortedArray;

public class Solution {
    public int search(int[] nums, int target) {
        if(nums.length==0) return -1;
        return search(nums,target,0,nums.length-1);
    }
    public int search(int[] nums, int target, int left, int right) {
        System.out.println(left+", "+right);
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) return mid;
        if (left >= right) {
            return -1;
        }
        if (nums[mid] >= nums[left]) {
            if (target >= nums[left] && target < nums[mid]) {
                return search(nums, target, left, mid - 1);
            }
            return search(nums, target, mid + 1, right);
        } else {
            if (target <= nums[right] && target > nums[mid]) {
                return search(nums, target, mid + 1, right);
            }
            return search(nums, target, left, mid - 1);
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(s.search(nums,3));
    }
}