package LeetCode.Q48RotateImage;

import java.util.Arrays;

import static LeetCode.Utility.UsefulMethods.print;

public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int r = 0; r<n/2; r++) {
            int start = r;
            int end = n-r-1;
            for(int c = start; c<end; c++) {
                int offset = c-start;
                int tmp = matrix[r][c];
                matrix[r][c] = matrix[end-offset][start];
                matrix[end-offset][start] = matrix[end][end-offset];
                matrix[end][end-offset] = matrix[c][end];
                matrix[c][end] = tmp;
//                print(r,c,"<-",end-offset,start);
//                print(end-offset,start,"<-",end,end-offset);
//                print(end,end-offset,"<-",c,end);
//                print(c,end,"<-",r,c);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] matrix = {
                {5,1,9,11},
                {2,4,8,10},
                {13,3,6,7},
                {15,14,12,16}
        };
        s.rotate(matrix);
        for(int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
