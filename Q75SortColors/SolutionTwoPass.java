//package LeetCode.Q75SortColors;
//
//import java.util.Arrays;
//
//public class SolutionTwoPass {
//    public void sortColors(int[] nums) {
//        int pivot = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if(nums[i]<nums[pivot]) {
//                swap(nums,i,pivot);
//            }
//            else pivot++;
//        }
//        System.out.println(Arrays.toString(nums));
//    }
//
//    public void swap(int[] nums, int a, int b) {
//        int tmp = nums[a];
//        nums[a]=nums[b];
//        nums[b]=tmp;
//    }
//
//    public static void main(String[] args) {
//        SolutionTwoPass s = new SolutionTwoPass();
//        int[] nums = {0,1,0,1};
//        s.sortColors(nums);
//    }
//}
