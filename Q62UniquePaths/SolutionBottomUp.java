package LeetCode.Q62UniquePaths;

public class SolutionBottomUp {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        dp[n-1] = 0;
        for(int r = m-1; r>=0; r--) {
            for(int c = n-1; c>=0; c--) {
                if(r==m-1 || c==n-1) dp[c]=1;
                else {
                    dp[c] = dp[c+1]+dp[c];
                }
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        SolutionBottomUp s = new SolutionBottomUp();
        System.out.println(s.uniquePaths(7,3));
    }
}
