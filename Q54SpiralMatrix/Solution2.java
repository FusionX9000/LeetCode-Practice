package LeetCode.Q54SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int c1 = 0, c2 = matrix[0].length-1;
        int r1 = 0, r2 = matrix.length-1;
        while(c1<=c2 && r1<=r2) {
            for(int c = c1; c<=c2; c++) result.add(matrix[r1][c]);
            for(int r = r1+1; r<=r2; r++) result.add(matrix[c2][r]);
            if(r1<r2 && c1<c2) {
                for(int c = c2-1; c>c2; c--) result.add(matrix[r2][c]);
                for(int r = r2; r>r1; r--) result.add(matrix[r][c1]);
            }
            c1++;
            c2--;
            r1++;
            r2--;
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
