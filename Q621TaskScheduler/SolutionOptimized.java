package LeetCode.Q621TaskScheduler;

import java.util.Arrays;

public class SolutionOptimized {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char task : tasks) {
            map[task - 'A']++;
        }
        Arrays.sort(map);
        int idle_slots = (map[25] - 1) * n;
        for (int i = 24; i >= 0; i--) {
            idle_slots -= Math.min(map[i], map[25] - 1);
        }
        return idle_slots + tasks.length;
    }

    public static void main(String[] args) {
        SolutionOptimized s = new SolutionOptimized();
        char[] tasks = {'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int n = 2;
        System.out.println(s.leastInterval(tasks, n));
    }
}

