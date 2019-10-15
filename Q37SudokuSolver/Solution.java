package LeetCode.Q37SudokuSolver;

import java.util.Arrays;

public class Solution {
    public void solveSudoku(char[][] board) {
        solveSudoku(board,0,0);
    }
    public boolean solveSudoku(char[][] board, int r, int c) {
        if(c==board.length) {
            r++;
            c=0;
        }
        if(r==board.length) {
            return true;
        }
        if(board[r][c]!='.') return solveSudoku(board,r,c+1);
        for(int x = 1; x<=9; x++) {
            char item = (char) (x+'0');
            if(canPut(board,r,c,item)) {
                board[r][c] = item;
                if(solveSudoku(board,r,c+1)) {
                    return true;
                }
            }
        }
        board[r][c]='.';
        return false;
    }
    public boolean canPut(char[][] board,int r, int c, char item) {
        int rowStart = 3*(r/3);
        int colStart = 3*(c/3);
        for(int i = 0; i<board.length; i++) {
            if(board[r][i]==item) return false;
            if(board[i][c]==item) return false;
            if(board[rowStart + i/3][colStart + i%3]==item) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        s.solveSudoku(board);
        for(char[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }
}
