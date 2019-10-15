package LeetCode.Q72EditDistance;

import java.util.Arrays;

public class SolutionOptimized {
    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        int[] editDist = new int[l2+1];
        for (int i = 0; i < l2 + 1; i++) editDist[i]=i;

        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();

        System.out.println("     "+Arrays.toString(w2));
        System.out.println("  "+Arrays.toString(editDist));
        for(int i = 1; i<=l1; i++) {
           int prev = editDist[0];
           editDist[0] = i;
           for(int j = 1; j<=l2; j++) {
               int c = w1[i-1] != w2[j-1] ? 1 : 0;
               int insert = 1 + editDist[j - 1];
               int remove = 1 + editDist[j];
               int update = prev + c;
               prev = editDist[j];
               editDist[j] = Math.min(update, Math.min(insert, remove));
           }
           System.out.println(w1[i-1]+" "+Arrays.toString(editDist));
        }
        return editDist[l2];
    }

    public static void main(String[] args) {
        SolutionOptimized s = new SolutionOptimized();
        String word1 = "intention";
        String word2 = "execution";
        System.out.println(s.minDistance(word1,word2));
    }
}

