package LeetCode.Q128LongestConsecutiveSequence;

import java.util.HashMap;

public class SolutionDSU {

    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;

        HashMap<Integer,Integer> map = new HashMap<>();

        DSU dsu = new DSU(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) continue;
            map.put(nums[i],i);
            if(map.containsKey(nums[i]-1)) {
                dsu.union(i,map.get(nums[i]-1));
            }
            if(map.containsKey(nums[i]+1)) {
                dsu.union(i,map.get(nums[i]+1));
            }
        }
        return dsu.maxSize();
    }

    public static void main(String[] args) {
        SolutionDSU s = new SolutionDSU();
        int[] nums = {0,0,0,0-1};
        System.out.println(s.longestConsecutive(nums));
    }
}
