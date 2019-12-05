package LeetCode.Q215KthLargestElementInAnArray;

import LeetCode.Utility.*;

import java.util.PriorityQueue;

public class Solution {

    public int findKthLargest(int[] nums, int k) {
        if(nums.length==0) return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if(k==0) {
                if(nums[i]>pq.peek()) {
                    pq.poll();
                    k++;
                } else continue;
            }
            pq.offer(nums[i]);
            k--;
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int nums[] = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println(s.findKthLargest(nums,k));
    }
}
