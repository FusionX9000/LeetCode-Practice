package LeetCode.Q56MergeIntervals;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b)->Integer.compare(a[0],b[0]));

        int[][] res = new int[intervals.length][intervals[0].length];
        res[0][0] = intervals[0][0];
        res[0][1] = intervals[0][1];

        int j = 0;

        for(int i = 1; i<intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if(start <= res[j][1]) {
                res[j][1] = Math.max(end,res[j][1]);
            } else {
                j++;
                res[j][0]=start;
                res[j][1]=end;
            }

        }
        return Arrays.copyOf(res,j);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] intervals = {
                {1,3},{2,6},{8,10},{15,18}
        };

        for(int[] interval : s.merge(intervals)) {
            System.out.println(Arrays.toString(interval));
        }
    }
}