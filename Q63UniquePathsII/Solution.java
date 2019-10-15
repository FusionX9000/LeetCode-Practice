package LeetCode.Q63UniquePathsII;

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length==0 || obstacleGrid[0].length==0) return 0;
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        for(int r = rows-1; r>=0; r--) {
            for (int c = cols - 1; c >= 0; c--) {
                if (obstacleGrid[r][c] == 1) obstacleGrid[r][c] = 0;
                else if (r == rows - 1 && c == cols - 1) obstacleGrid[r][c] = 1;
                else if (r == rows - 1) obstacleGrid[r][c] = obstacleGrid[r][c + 1];
                else if (c == cols - 1) obstacleGrid[r][c] = obstacleGrid[r + 1][c];
                else obstacleGrid[r][c] = obstacleGrid[r + 1][c] + obstacleGrid[r][c + 1];
            }
        }
        return obstacleGrid[0][0];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] obstacleGrid = {
                {0,0,0},
                {0,0,0}
        };
        System.out.println(s.uniquePathsWithObstacles(obstacleGrid));
    }
}
