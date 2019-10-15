package LeetCode.Q52NQueensII;

public class Solution {
    int count = 0;
    public int totalNQueens(int n) {
        boolean[] cols = new boolean[n];
        boolean[] d1 = new boolean[2*n];
        boolean[] d2 = new boolean[2*n];
        totalNQueens(n,0,cols,d1,d2);
        return count;
    }
    public void totalNQueens(int n, int r, boolean[] cols, boolean[] d1, boolean[] d2) {
        if(r==n) count++;
        for(int c = 0; c<n; c++) {
            int id1 = r-c+n;
            int id2 = r+c;
            if(cols[c] || d1[id1] || d2[id2]) continue;
            cols[c] = true; d1[id1] = true; d2[id2] = true;
            totalNQueens(n,r+1,cols,d1,d2);
            cols[c] = false; d1[id1] = false; d2[id2] = false;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.totalNQueens(8));
    }
}
