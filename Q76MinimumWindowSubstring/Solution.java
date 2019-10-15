package LeetCode.Q76MinimumWindowSubstring;

import java.util.*;

public class Solution {
    public String minWindow(String s, String t) {
        if(t.length()==0 || s.length()==0 || s.length()<t.length()) return "";
        HashMap<Character,Integer> map = createMap(t);
        HashMap<Character,Integer> reference = new HashMap<>();
        int left = 0;
        int right = 0;
        int minLeft = 0;
        int minRight = s.length();
        int charCount = 0;
        for (right = t.length()-1; right < s.length(); right++) {
            char atRight = s.charAt(right);
            if(map.containsKey(atRight)) {
                reference.putIfAbsent(atRight, 0);
                if(reference.get(atRight)<map.get(atRight)) charCount++;
                reference.put(atRight, reference.get(atRight)+1);
            }
            while(left<right && (right-left+1)>charCount) {
                char atLeft = s.charAt(left);
                if(map.containsKey(atLeft)) {
                    if(reference.containsKey(atLeft) && reference.get(atLeft)>map.get(atLeft)) {
                        left++;
                        reference.put(atLeft,reference.get(atLeft)-1);
                    }
                    else break;
                } else left++;
            }
            if(charCount==t.length() && (minRight-minLeft+1>right-left+1)) {
                minLeft = left;
                minRight = right;
            }
        }
        return charCount!=t.length() ? "" : s.substring(minLeft,minRight+1);
    }

    public HashMap<Character, Integer> createMap(String t) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char ch : t.toCharArray()) {
            map.putIfAbsent(ch,0);
            map.put(ch,map.get(ch)+1);
        }
        return map;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String S = "aaaaaaaaaaaabbbbbcdd";
        String T = "cd";
        System.out.println(s.minWindow(S,T));
    }
}
