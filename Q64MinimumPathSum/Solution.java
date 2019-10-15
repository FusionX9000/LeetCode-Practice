package LeetCode.Q64MinimumPathSum;

public class Solution {
    public int minPathSum(int[][] grid) {
        if(grid.length==0 || grid[0].length==0) return 0;
        for(int r = 0; r<grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if(r==0 && c==0) continue;
                else if(r==0) grid[r][c]+=grid[r][c-1];
                else if(c==0) grid[r][c]+=grid[r-1][c];
                else grid[r][c]+= Math.min(grid[r][c-1],grid[r-1][c]);
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] grid = {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        System.out.println(s.minPathSum(grid));

    }
}
