package LeetCode.Q71SimplifyPath;

import LeetCode.Utility.UsefulMethods;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<String> splitPath(String path) {
        List<String> split_words = new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        for(int i = 0; i<path.length(); i++) {
            char ch = path.charAt(i);
            if(ch=='/') {
                if(sb.length()!=0) {
                    split_words.add(sb.toString());
                    sb = new StringBuilder();
                }
            } else {
                sb.append(ch);
                if(i+1==path.length()) split_words.add(sb.toString());
            }
        }
        return split_words;
    }
    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        for(String word : splitPath(path)) {
            if(!stack.isEmpty() && word.equals("..")) stack.removeLast();
            else if(!word.equals(".") && !word.equals("..")) stack.add(word);
        }
        if(stack.isEmpty()) return "/";
        StringBuilder res = new StringBuilder();
        for(String word : stack) res.append("/").append(word);
        return res.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String inp = "/./";
        System.out.println(s.simplifyPath(inp));
        String inp2 = "/a/../../b/../c//.//";
        System.out.println(s.simplifyPath(inp2));
        String inp3 = "/a//b////c/d//././/..";
        System.out.println(s.simplifyPath(inp3));
    }
}
