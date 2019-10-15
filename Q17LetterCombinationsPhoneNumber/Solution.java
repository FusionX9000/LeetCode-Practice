package LeetCode.Q17LetterCombinationsPhoneNumber;

import java.util.ArrayList;
import java.util.List;

public class Solution {
// Memory Limit Exceeded
//    public List<String> letterCombinations(String digits, int pos) {
//        if(pos==digits.length()-1) {
//            List<String> res = new ArrayList<>();
//            for(char c : getList(digits.charAt(pos))) {
//                res.add(String.valueOf(c));
//            }
//            return res;
//        }
//        List<String> results = new ArrayList<>();
//        List<String> currResult = letterCombinations(digits,pos+1);
//        for(char c : getList(digits.charAt(pos))) {
//            for(String s : currResult) results.add(c+s);
//        }
//        return results;
//    }
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.equals("")) return result;
        letterCombinations(result,"",digits,0);
        return result;
    }
    public void letterCombinations(List<String> result, String prefix, String digits, int pos) {
        if(pos==digits.length()) {
            result.add(prefix);
        } else {
            String nextdigit = digits.substring(pos,pos+1);
            for(char c : getList(nextdigit.charAt(0))) {
                letterCombinations(result,prefix+c,digits,pos+1);
            }
        }
    }

    public char[] getList(char c) {
        switch(c) {
            case '2':
                return new char[] {'a','b','c'};
            case '3':
                return new char[] {'d','e','f'};
            case '4':
                return new char[] {'g','h','i'};
            case '5':
                return new char[] {'j','k','l'};
            case '6':
                return new char[] {'m','n','o'};
            case '7':
                return new char[] {'p','q','r','s'};
            case '8':
                return new char[] {'t','u','v'};
            case '9':
                return new char[] {'w','x','y','z'};
            default:
                return null;
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.letterCombinations("23").toString());
    }
}
