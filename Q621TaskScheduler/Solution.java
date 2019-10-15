package LeetCode.Q621TaskScheduler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            map[tasks[i] - 'A']++;
        }
        Arrays.sort(map);
        int time = 0;
        int remaining = tasks.length;
        while (map[25] > 0) {
            int i = 0;
            while (i <= n) {
                if (i < 26 && map[25 - i] > 0) {
                    map[25 - i]--;
                    remaining--;
                }
                i++;
                time++;
                if(remaining==0) break;
            }
            Arrays.sort(map);
        }
        return time;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        System.out.println(s.leastInterval(tasks, n));
    }
}
