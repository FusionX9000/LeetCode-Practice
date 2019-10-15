package LeetCode.Q72EditDistance;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        int[][] editDist = new int[l1+1][l2+1];
        for(int i = 0; i<l1+1; i++) {
            for(int j = 0; j<l2+1; j++) {
                if(i==0 || j==0) editDist[i][j] = i==0 ? j : i;
                else {
                    int c = word1.charAt(i-1)!=word2.charAt(j-1) ? 1 : 0;
                    int insert = 1+editDist[i][j-1];
                    int remove = 1+editDist[i-1][j];
                    int replace = editDist[i-1][j-1]+ c;
                    editDist[i][j] = Math.min(insert,Math.min(remove,replace));
                }
            }
        }
        for(int[] a : editDist) System.out.println(Arrays.toString(a));
        return editDist[l1][l2];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String word1 = "eat";
        String word2 = "sea";
        System.out.println(s.minDistance(word1,word2));
    }
}
