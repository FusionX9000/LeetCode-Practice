package LeetCode.Q56MergeIntervals;

import LeetCode.Utility.UsefulMethods;

import java.util.*;

public class SolutionGraph {
    private Map<Interval, List<Interval>> graph;
    private Map<Integer, List<Interval>> nodesInComp;
    private Set<Interval> visited;

    private boolean overlap(Interval a, Interval b) {
        return a.start <= b.end && a.end >= b.start;
    }

    public List<Interval> buildIntervals(int[][] intervals) {
        List<Interval> list = new ArrayList<>();
        for(int i = 0; i<intervals.length; i++) {
            list.add(new Interval(intervals[i][0],intervals[i][1]));
        }
        return list;
    }

    private void buildGraph(List<Interval> intervals) {
        graph = new HashMap<>();
        for (Interval interval : intervals) {
            graph.put(interval, new LinkedList<>());
        }
        for (int i = 0; i < intervals.size() - 1; i++) {
            for (int j = i + 1; j < intervals.size(); j++) {
                Interval interval1 = intervals.get(i);
                Interval interval2 = intervals.get(j);
                if(overlap(interval1,interval2)) {
                    graph.get(interval1).add(interval2  );
                    graph.get(interval2).add(interval1);
                }
            }
        }
    }

    private Interval mergeNodes(List<Interval> intervals) {
        int minStart = intervals.get(0).start;
        for (Interval interval : intervals) {
            minStart = Math.min(interval.start, minStart);
        }
        int maxEnd = intervals.get(0).end;
        for (Interval interval : intervals) {
            maxEnd = Math.max(interval.end, maxEnd);
        }
        return new Interval(minStart, maxEnd);
    }

    private void markComponentDFS(Interval start, int compNumber) {
        Stack<Interval> stack = new Stack<>();
        stack.add(start);
        while (!stack.isEmpty()) {
            Interval node = stack.pop();
            if (!visited.contains(node)) {
                visited.add(node);

                nodesInComp.putIfAbsent(compNumber, new LinkedList<>());
                nodesInComp.get(compNumber).add(node);

                stack.addAll(graph.get(node));
            }
        }
    }

    private void buildComponents(List<Interval> intervals) {
        nodesInComp = new HashMap<>();
        visited = new HashSet<>();
        int compNumber = 0;
        for(Interval interval : intervals) {
            if(!visited.contains(interval)) {
                markComponentDFS(interval,compNumber);
                compNumber++;
            }
        }
    }

    public int[][] merge(int[][] intvals) {
        List<Interval> intervals = buildIntervals(intvals);

        buildGraph(intervals);
        buildComponents(intervals);

        System.out.println(graph);
        System.out.println(nodesInComp);

        int[][] res = new int[nodesInComp.size()][2];
        for(int i = 0; i<res.length; i++) {
            Interval tmp = mergeNodes(nodesInComp.get(i));
            res[i][0]=tmp.start;
            res[i][1]=tmp.end;
        }

        return res;
    }

    public static void main(String[] args) {
        SolutionGraph s = new SolutionGraph();

        int[][] intervals = {
                {1,3},{2,6},{8,10},{15,18}
        };

        int[][] result = s.merge(intervals);
        for(int i = 0; i<result.length; i++) {
            System.out.println(result[i][0]+", "+result[i][1]);
        }
    }

}
