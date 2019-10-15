package LeetCode.Q32LongestValidParentheses;

import java.util.Stack;

public class SolutionDP {
    public int longestValidParentheses(String s) {
        if(s.length()<2) return 0;
        int[] dp = new int[s.length()];
        dp[0] = 0;
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1]>0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + (i - dp[i - 1] >=0 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                max=Math.max(dp[i],max);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        SolutionDP s = new SolutionDP();
        System.out.println(s.longestValidParentheses(")()())"));
    }
}
