package LeetCode.Q14LongestCommonPrefix;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0) return "";
        StringBuilder prefix = new StringBuilder(strs[0].length());
        for(int i  = 0; i<strs[0].length(); i++) {
            char ch = strs[0].charAt(i);
            for(int j = 0; j<strs.length; j++) {
                if(i>=strs[j].length() || strs[j].charAt(i)!=ch) {
                    return prefix.toString();
                }
            }
            prefix.append(ch);
        }
        return prefix.toString();
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestCommonPrefix(new String[] {"leets","leet","leetcode","lee"}));
    }
}
