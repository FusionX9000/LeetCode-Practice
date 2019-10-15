package LeetCode.Q207CourseScheduler;

import java.util.*;

public class Solution {

    //VISITED = safe nodes, VISITING = nodes which are being processed, UNVISIted = nodes not yet processed
    public enum State {UNVISITED, VISITED, VISITING}

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        //Build Graph using adjacency list
        List<List<Integer>> map = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            map.add(new ArrayList<Integer>());
        }

        for(int[] pair : prerequisites) {
            map.get(pair[1]).add(pair[0]);
        }

        //Initialize all nodes to be unvisited
        State[] state = new State[numCourses];
        for (int i = 0; i < numCourses; i++) {
            state[i]= State.UNVISITED;
        }

        //Performing DFS over all nodes
        for(int course = 0; course<numCourses; course++) {
            if(state[course]==State.UNVISITED) {
                if(!dfs(course, map, state)) return false;
            }
        }
        return true;
    }

    public boolean dfs(int course, List<List<Integer>> map, State[] state) {

        if(state[course]==State.VISITING) return false;
        else if(state[course]==State.VISITED) return true;

        state[course] = State.VISITING;

        for(int next : map.get(course)) {
            if (!dfs(next,map,state)) return false;
        }

        state[course]=State.VISITED;
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int numCourses = 3;
        int[][] prerequisites = {
                {1,0},
                {0,1},
                {1,2}
        };
        System.out.println(s.canFinish(numCourses,prerequisites));
    }
}
