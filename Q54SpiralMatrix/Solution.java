package LeetCode.Q54SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix.length==0 || matrix[0].length==0) return result;
        int R = matrix.length;
        int C = matrix[0].length;
        int[] dr = {0,1,0,-1};
        int[] dc = {1,0,-1,0};
        boolean[][] seen = new boolean[R][C];
        int di = 0, r = 0, c = 0;
        for(int i = 0; i<R*C; i++) {
            result.add(matrix[r][c]);
            seen[r][c] = true;

            int cr = r + dr[di];
            int cc = c + dc[di];

            if(cr<R && cr>=0 && cc<C && cc>=0 && !seen[cr][cc]) {
                r = cr;
                c = cc;
            } else {
                di = (di+1)%4;
                r+=dr[di];
                c+=dc[di];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        System.out.println(s.spiralOrder(matrix));
    }
}
