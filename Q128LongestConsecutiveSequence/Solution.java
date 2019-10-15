package LeetCode.Q128LongestConsecutiveSequence;

import LeetCode.Utility.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int longestConsecutive(int[] nums) {
        int max = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for(int num : set) {
            if(set.contains(num-1)) continue;
            int curr = num+1;
            int sv = 1;
            while(set.contains(curr)) {
                sv++;
                curr++;
            }
            max = Math.max(sv,max);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,2,3,5};
        System.out.println(s.longestConsecutive(nums));
    }
}
