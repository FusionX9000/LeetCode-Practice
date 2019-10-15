package LeetCode.Q49GroupAnagrams;

import LeetCode.Utility.UsefulMethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> results = new ArrayList<>();
        HashMap<String,List<String>> map = new HashMap<>();
        for(String s : strs) {
            String sortedString = sortString(s);
            if(!map.containsKey(sortedString)) {
                map.put(sortedString,new ArrayList<>());
            }
            map.get(sortedString).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public String sortString(String s) {
        char[] tmp = s.toCharArray();
        Arrays.sort(tmp);
        return new String(tmp);
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] strs = {};
        UsefulMethods.print(s.groupAnagrams(strs));
    }
}
