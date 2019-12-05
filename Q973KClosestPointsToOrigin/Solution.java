package LeetCode.Q973KClosestPointsToOrigin;

import LeetCode.Utility.*;

import java.util.Arrays;
import java.util.Random;

public class Solution {
    public int[][] kClosest(int[][] points, int K) {
        if(points.length<=1 || K>=points.length) return points;
        int l = 0;
        int r = points.length-1;
        while(l<=r) {
            int k = quickselect(points,l,r);
            if(k==K) {
                return Arrays.copyOf(points,k);
            }
            else if(k<K) l=k+1;
            else r=k-1;
        }
        return null;
    }

    public int quickselect(int[][] points, int l, int r) {
        int pivot = (l+r)/2;
        swap(points,pivot,r);

        int i = l-1;

        for (int j = l; j < r; j++) {
            if(distance(points[j])<distance(points[r])) {
                swap(points,++i,j);
            }
        }

        swap(points,++i,r);
        return i;
    }

    public void swap(int[][] nums, int a, int b) {
        int[] tmp = nums[a];
        nums[a]=nums[b];
        nums[b]=tmp;
    }

    public int distance(int[] point) {
        return point[0]*point[0] + point[1]*point[1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] points = {{1,3},{-2,2}};
        int K = 1;
        int[][] res = s.kClosest(points,K);
        for(int[] point : res) System.out.println(Arrays.toString(point));
    }
}
