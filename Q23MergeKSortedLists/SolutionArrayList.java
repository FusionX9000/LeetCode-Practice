package LeetCode.Q23MergeKSortedLists;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class ListID {
    int val;
    int id;
    int ptr;
    public ListID(int id, int val, int ptr) {
        this.id = id;
        this.val = val;
        this.ptr = ptr;
    }
}

public class SolutionArrayList {
    public List<Integer> mergeKLists(List<List<Integer>> lists) {
        PriorityQueue<ListID> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i) != null && lists.get(i).size() != 0) {
                ListID ld = new ListID(i, lists.get(i).get(0), 0);
                queue.offer(ld);
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            ListID ld = queue.poll();
            result.add(ld.val);
            if (ld.ptr != lists.get(ld.id).size() - 1)
                queue.offer(new ListID(ld.id, lists.get(ld.id).get(ld.ptr + 1), ld.ptr + 1));
        }
        return result;
    }

    public static void main(String[] args) {
        SolutionArrayList s = new SolutionArrayList();
        List<Integer> l1 = Arrays.asList(1,4,5);
        List<Integer> l2 = Arrays.asList(1,3,4);
        List<Integer> l3 = Arrays.asList(5,9,12);
        List<Integer> result = s.mergeKLists(Arrays.asList(l1,l2,l3));
        System.out.println(result);
    }
}