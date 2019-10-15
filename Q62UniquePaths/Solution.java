package LeetCode.Q62UniquePaths;

public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return uniquePaths(m,n,0,0,dp);
    }
    public int uniquePaths(int m, int n, int r, int c, int[][]dp) {
        if(r==m || c==n) return 0;
        if(dp[r][c]>0) return dp[r][c];
        if(r==m-1 && c==n-1) {
            return 1;
        }
        dp[r][c] = uniquePaths(m,n,r+1,c,dp) + uniquePaths(m,n,r,c+1,dp);
        return dp[r][c];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.uniquePaths(7,3));
    }
}
