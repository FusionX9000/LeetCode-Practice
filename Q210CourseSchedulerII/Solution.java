package LeetCode.Q210CourseSchedulerII;

import java.util.*;

public class Solution {
    //VISITED = safe nodes, VISITING = nodes which are being processed, UNVISIted = nodes not yet processed
    public enum State {UNVISITED, VISITED, VISITING}


    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] result = new int[numCourses];

        List<List<Integer>> map = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            map.add(new ArrayList<Integer>());
        }

        for(int[] pair : prerequisites) {
            map.get(pair[1]).add(pair[0]);
        }

        State[] state = new State[numCourses];
        for (int i = 0; i < numCourses; i++) {
            state[i]= State.UNVISITED;
        }

        Deque<Integer> stack = new LinkedList<>();
        for(int course = 0; course<numCourses; course++) {
            if(state[course]==State.UNVISITED) {
                if(!dfs(course, map, state, stack)) return result;
            }
        }
        for (int i = 0; i < numCourses; i++) {
            result[i]=stack.pop();
        }
        return result;
    }

    public boolean dfs(int course, List<List<Integer>> map, State[] state, Deque<Integer> stack) {

        if(state[course]==State.VISITING) return false;
        else if(state[course]==State.VISITED) return true;

        state[course] = State.VISITING;

        for(int next : map.get(course)) {
            if (!dfs(next,map,state, stack)) return false;
        }
        stack.push(course);
        state[course]=State.VISITED;
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int numCourses = 3;
        int[][] prerequisites = {
                {1,0},
                {2,0},
                {3,1}
        };
        System.out.println(Arrays.toString(s.findOrder(numCourses,prerequisites)));
    }
}
