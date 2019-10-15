package LeetCode.Q140WordBreakII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
    HashMap<String,List<String>> cache = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        if(cache.containsKey(s)) return cache.get(s);
        List<String> result = new ArrayList<>();
        if(s.length()==0) {
            result.add("");
            return result;
        }
        for(String word : wordDict) {
            if(s.startsWith(word)) {
                List<String> rest = wordBreak(s.substring(word.length()),wordDict);
                for(String sen : rest) {
                    result.add(word + (sen.isEmpty() ? "" : " ") + sen);
                }
            }
        }
        cache.put(s,result);
        return cache.get(s);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
        String sen = "catsanddog";
        System.out.println(sen.length());
        System.out.println(s.wordBreak(sen, wordDict));
    }
}
