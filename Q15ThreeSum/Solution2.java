package LeetCode.Q15ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    public List<List<Integer>> threeSum(int nums[]) {
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        for(int i = 0; i<nums.length-2; i++) {
            if (nums[i]>0) return results;
            if(i==0 || nums[i-1]!=nums[i]) {
                int l = i+1;
                int r = nums.length-1;
                while(l<r) {
                    if(nums[i]+nums[l]+nums[r]==0) {
                        results.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l+1]) l++;
                        while (l < r && nums[r] == nums[r-1]) r--;
                        l++;r--;
                    } else if(nums[i]+nums[l]+nums[r]>0) {
                        r--;
                    } else {
                        l++;
                    }
                }
            }
        }
        return results;
    }
    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int[] nums = new int[]{1,-1,-1,0};
        List<List<Integer>> results = s.threeSum(nums);
        for (List<Integer> result : results) {
            System.out.println(result.toString());
        }
    }
}
