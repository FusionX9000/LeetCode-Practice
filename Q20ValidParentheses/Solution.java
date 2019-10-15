package LeetCode.Q20ValidParentheses;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(char c : s.toCharArray()) {
            if(c=='(' || c=='{' || c=='[') {
                stack.push(c);
            } else {
                if(stack.isEmpty()) return false;
                if(c==')') {
                    if(stack.peek()=='(') stack.pop();
                    else return false;
                }
                if(c=='}') {
                    if(stack.peek()=='{') stack.pop();
                    else return false;
                }
                if(c==']') {
                    if(stack.peek()=='[') stack.pop();
                    else return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isValid("(([)]"));
    }
}
