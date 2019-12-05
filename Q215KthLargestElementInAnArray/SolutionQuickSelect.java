package LeetCode.Q215KthLargestElementInAnArray;

import LeetCode.Utility.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class SolutionQuickSelect {

    public int quickSelect(int[] nums, int L, int R, int pivot) {
        while(L<=R) {
            while(nums[L]<pivot) L++;

            while (nums[R]>pivot) R--;

            if(L<=R) {
                swap(nums,L,R);
                L++;
                R--;
            }
        }
        return L;
    }

    public int lomuto(int[] nums, int L, int R, int pivot) {
        int i = L-1;
        int p = nums[pivot];
        swap(nums,R,pivot);
        for (int j = L; j < R; j++) {
            if(nums[j]<p) {
                i++;
                swap(nums,j,i);
            }
        }
        swap(nums,++i,R);
        return i;
    }

    public void swap(int nums[], int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public int findKthLargest(int[] nums, int k) {
        int L=0;
        int R = nums.length-1;
        Random rand = new Random();
        while(L<=R) {
            int index = lomuto(nums,L,R,rand.nextInt(R-L+1)+L);
            int rank = nums.length-index;
            if(rank>k) {
                L=index+1;
            } else if(rank<k) {
                R=index-1;
            } else return nums[index];
        }
        return -1;
    }

    public static void main(String[] args) {
        SolutionQuickSelect s = new SolutionQuickSelect();
        int nums[] = {6,4,2,5,1,0,10,3};
        int k = 8;
        System.out.println(s.findKthLargest(nums,k));

//        int p = s.lomuto(nums,0,nums.length-1,1);
//        System.out.println(p);
//        System.out.println(Arrays.toString(nums));

    }
}
