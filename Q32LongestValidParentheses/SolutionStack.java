package LeetCode.Q32LongestValidParentheses;

import java.util.Stack;

public class SolutionStack {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxlen = 0;
        for(int i = 0; i<s.length(); i++) {
            if(s.charAt(i)==')') {
                stack.pop();
                if(stack.isEmpty()) stack.push(i);
                maxlen = Math.max(maxlen, i-stack.peek());
            } else {
                stack.push(i);
            }
        }
        return maxlen;
    }
    public static void main(String[] args) {
        SolutionStack s = new SolutionStack();
        System.out.println(s.longestValidParentheses(")()())"));
    }
}
