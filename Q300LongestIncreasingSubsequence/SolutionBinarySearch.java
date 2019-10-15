package LeetCode.Q300LongestIncreasingSubsequence;

import java.util.Arrays;
import java.util.Random;

public class SolutionBinarySearch {
    public int lengthofLIS(int[] nums) {
        int[] M = new int[nums.length+1];
        int L = 0;
        for(int i = 0; i<nums.length; i++) {
            int lo = 1;
            int hi = L;
            while(lo<=hi) {
                int mid = (lo+hi)/2;
                if(nums[i]>nums[M[mid]]) {
                    lo = mid+1;
                } else hi = mid-1;
            }
            int newL = lo;
            M[newL] = i;
            if(newL>L) L=newL;
        }
        return L;
    }

    public int lengthofLIS2(int[] nums) {
        int[] M = new int[nums.length+1];
        int L = 0;
        for(int i = 0; i<nums.length; i++) {
            int lo = 1;
            int hi = L+1;
            while(lo<hi) {
                int mid = (lo+hi)/2;
                if(nums[i]>nums[M[mid]]) {
                    lo = mid+1;
                } else hi = mid;
            }
            int newL = lo;
            M[newL] = i;
            if(newL>L) L=newL;
        }
        return L;
    }

    public static int[] randomIntArray(int length, int range) {
        int[] result = new int[length];
        Random r = new Random();
        for (int i = 0; i < length; i++) {
            result[i] = r.nextInt(range);
        }
        return result;
    }

    public static void main(String[] args) {
        SolutionBinarySearch s = new SolutionBinarySearch();
        int[] nums = {1,2,3,4,5};
        System.out.println(s.lengthofLIS(nums));
        for (int i = 0; i < 100; i++) {
            nums = randomIntArray(new Random().nextInt(50),100);
            System.out.println(Arrays.toString(nums));
            System.out.println(s.lengthofLIS(nums) +" "+s.lengthofLIS2(nums));
            System.out.println(s.lengthofLIS(nums)==s.lengthofLIS2(nums) ? "true" : "false");
        }
    }
}
