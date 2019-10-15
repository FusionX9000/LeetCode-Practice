package LeetCode.Q30SubstringWithConcatenationOfAllWords;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> results = new ArrayList<>();
        if(words.length==0) return null;
        HashMap<String,Integer> count = new HashMap<>();
        for(String word : words) {
            count.put(word, count.getOrDefault(word,0)+1);
        }
        int num = words[0].length();
        int len = words.length;
        for(int i = 0; i<=s.length()-(num*len); i++) {
            HashMap<String, Integer> seen = new HashMap<>();
            int j = 0;
            while(j<len) {
                String sb = s.substring(i+(j*num),i+(j+1)*num);
                if(count.containsKey(sb)) {
                    seen.put(sb, seen.getOrDefault(sb,0)+1);
                    if(seen.get(sb)>count.get(sb)) break;
                } else break;
                j++;
            }
            if(j==len) {
                results.add(i);
            }
        }
        return results;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] words = {"foo","bar"};
        String str = "barfoothefoobarman";
        System.out.println(s.findSubstring(str,words).toString());
    }
}
