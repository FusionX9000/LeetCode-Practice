package LeetCode.Q621TaskScheduler;

import java.util.*;

public class SolutionPQ {
    public int leastInterval(char[] tasks, int n) {
        if(tasks.length==0) return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        int[] map = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            map[tasks[i]-'A']++;
        }
        for (int i = 0; i < 26 ; i++) {
            if(map[i]==0) continue;
            pq.offer(map[i]);
        }

        int time = 0;
        while(pq.peek()!=null) {
            int i = 0;
            List<Integer> tmp = new ArrayList<>();
            while(i<=n) {
                if(!pq.isEmpty()) {
                    int x = pq.poll()-1;
                    if(x>0) tmp.add(x);
                } else if(tmp.isEmpty()) break;
                time++;
                i++;
            }
            pq.addAll(tmp);
        }
        return time;
    }

    public static void main(String[] args) {
        SolutionPQ s = new SolutionPQ();
        char[] tasks = {'A','A','A','A','A','A','B','C','D','E','F','G'};
        int n = 2;
        System.out.println(s.leastInterval(tasks, n));
    }
}
