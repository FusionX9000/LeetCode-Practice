package LeetCode.Q51NQueens;

import LeetCode.Utility.UsefulMethods;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        solveNQueens(n,0,new Integer[n],results);
        UsefulMethods.print(results.size());
        return results;
    }

    public void solveNQueens(int n, int r, Integer[] columns, List<List<String>> results) {
        if(r==n) {
            results.add(buildListString(columns));
        }
        for(int c = 0; c < n; c++ ) {
            if(canPut(n,r,c,columns)) {
                columns[r] = c;
                solveNQueens(n,r+1,columns,results);
            }
        }
    }

    public boolean canPut(int n, int r, int c, Integer[] columns) {
        for(int r2 = 0; r2<r; r2++) {
            int c2 = columns[r2];
            if(c2==c) {
                return false;
            }
            if(Math.abs(r-r2)==Math.abs(c-c2)) {
                return false;
            }
        }
        return true;
    }

    public List<String> buildListString(Integer[] columns) {
        List<String> result = new ArrayList<>();
        for(int i : columns) {
            StringBuilder sb = new StringBuilder(columns.length);
            for(int j = 0; j<columns.length; j++) {
                if(j==i) sb.append("Q");
                else sb.append(".");
            }
            result.add(sb.toString());
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        UsefulMethods.print(s.solveNQueens(4));
    }
}
