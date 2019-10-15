package LeetCode.Q1004MaxConsecutiveOnesIII;

import java.util.Arrays;

public class Solution {
    public int longestOnes(int[] A, int K) {
        int left = 0;
        int right;
        for (right = 0; right < A.length; right++) {
            if(A[right]==0) K--;
            if(K<0 && A[left++]==0) K++;
        }
        return right-left;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] A = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int K = 3;
        System.out.println(s.longestOnes(A,K));
    }
}
