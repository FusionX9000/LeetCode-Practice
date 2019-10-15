package LeetCode.Q200NumberOfIslands;

public class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length==0 || grid[0].length==0) return 0;
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if(grid[i][j]=='1') {
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid, int r, int c) {
        if(r<0 || r>=grid.length || c<0 || c>=grid[0].length) {
            return;
        }
        if(grid[r][c]=='1') {
            grid[r][c]='2';
            dfs(grid,r+1,c);
            dfs(grid,r-1,c);
            dfs(grid,r,c+1);
            dfs(grid,r,c-1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}

        };
        System.out.println(s.numIslands(grid));
    }
}
