package LeetCode.Q57InsertInterval;

import java.util.Arrays;

public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length==0 || intervals[0].length==0) return new int[][]{newInterval};
        int[][] res = new int[intervals.length+1][2];
        int i = 0;
        while(i<intervals.length && newInterval[0]>intervals[i][1]) {
            res[i] = intervals[i];
            i++;
        }
        int c = i;
        while(c<intervals.length && intervals[c][0]<=newInterval[1]) {
            newInterval[0] = Math.min(intervals[c][0],newInterval[0]);
            newInterval[1] = Math.max(intervals[c++][1],newInterval[1]);
        }

        res[i++] = newInterval;

        while(c<intervals.length) res[i++] = intervals[c++];

        return Arrays.copyOf(res,i);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] intervals = {
                {1,3},{6,9}
        };
        int[] newInterval = {2,5};
        for(int[] interval : s.insert(intervals,newInterval)) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
