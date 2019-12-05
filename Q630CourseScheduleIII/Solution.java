package LeetCode.Q630CourseScheduleIII;

import LeetCode.Utility.*;

import java.util.*;

class PairComparator implements Comparator<int[]> {
    public int compare(int[] a, int b[]) {
        return a[1] - b[1];
    }
}

public class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses,new PairComparator());
        int currTime = 0;
        int count = 0;
        int max = 0;

        Deque<int[]> stack = new LinkedList<>();

        for(int[] course : courses) {
            System.out.println(Arrays.toString(course));
            int duration = course[0];
            int deadline = course[1];
            while(!stack.isEmpty()&&currTime+duration>deadline) {
                currTime -= stack.pop()[0];
                count--;
            }
            stack.push(course);
            currTime+=duration;
            count++;
            max = Math.max(count,max);
        }
        return max;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] courses = {{5,15},{3,19},{6,7},{2,10},{5,16},{8,14},{10,11},{2,19}};
        System.out.println(s.scheduleCourse(courses));
    }
}
