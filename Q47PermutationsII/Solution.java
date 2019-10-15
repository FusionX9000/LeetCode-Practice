package LeetCode.Q47PermutationsII;

import java.util.*;
import java.util.List;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums) {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        permuteUnique(map,new ArrayList<Integer>(),nums.length,results,0);
        return results;
    }
    public void permuteUnique(Map<Integer,Integer> map, List<Integer> result, int remaining, List<List<Integer>> results, int level) {
        if(remaining==0) {
            System.out.println(result.toString());
            results.add(new ArrayList<>(result));
            return;
        }
        for(Integer i : map.keySet()) {
            int count = map.get(i);
            if(count>0) {
                System.out.println("level: "+level+" "+map.toString());
                map.put(i,count-1);
                result.add(i);
                permuteUnique(map,result,remaining-1,results,level+1);
                result.remove(result.size()-1);
                map.put(i,count);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {2,1,2,1};
        for(List<Integer> res : s.permuteUnique(nums)) {
            System.out.println(res.toString());
        }

    }
}
