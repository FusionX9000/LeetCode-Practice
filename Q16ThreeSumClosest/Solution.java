package LeetCode.Q16ThreeSumClosest;

import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int nums[], int target) {
        Arrays.sort(nums);
        int sum = nums[0]+nums[1]+nums[2];
        for(int i = 0; i<nums.length-2; i++) {
            if(i==0 || nums[i-1]!=nums[i]) {
                int l = i+1;
                int r = nums.length-1;
                while(l<r) {
                    int currSum = nums[i]+nums[l]+nums[r];
                    if(Math.abs(target-currSum)<Math.abs(target-sum)) {
                        sum = currSum;
                    }
                    if(currSum<target) {
                        while(l<r&&nums[l]==nums[l+1]) l++;
                        l++;
                    } else if(currSum==target) {
                        return currSum;
                    } else {
                        while(l<r&&nums[r]==nums[r-1]) r--;
                        r--;
                    }
                }
            }
        }
        return sum;
    }
    // -1,0,1,1,55
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.threeSumClosest(new int[]{-1,0,1,1,55},3));
    }
}
