package LeetCode.Q46Permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        return permute(nums, 0);
    }
    public List<List<Integer>> permute(int[] nums, int pos) {
        List<List<Integer>> result = new ArrayList<>();
        if(pos==nums.length) {
            result.add(new ArrayList<>());
            return result;
        }
        List<List<Integer>> intResult = permute(nums,pos+1);
        for(List<Integer> res : intResult) {
            for(int i = 0; i<res.size()+1; i++) {
                List<Integer> tmp = new ArrayList<>(res);
                tmp.add(i,nums[pos]);
                result.add(tmp);
            }
        }
        return result;
    }

//    public List<List<Integer>> permute2(int[] nums) {
//        List<List<Integer>> results = new ArrayList<>();
//        permute2(nums,0,results, new ArrayList<Integer>());
//        return results;
//    }
//    public void permute2(int[] nums, int pos, List<List<Integer>> results, List<Integer> result) {
//        if(pos==nums.length) {
//            results.add(new ArrayList<>(result));
//            return;
//        }
//        for(int i = pos; i<nums.length; i++) {
//            result.add(nums[i]);
//            swap(nums,i,pos);
//            permute2(nums,pos+1,results,result);
//            swap(nums,i,pos);
//            result.remove(result.size()-1);
//        }
//
//    }
//    public void swap(int[] nums, int i, int j) {
//        int tmp = nums[i];
//        nums[i]=nums[j];
//        nums[j]=tmp;
//    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,2,3};
        for(List<Integer> res : s.permute(nums)) {
            System.out.println(res.toString());
        }
    }
}
