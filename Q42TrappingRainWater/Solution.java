package LeetCode.Q42TrappingRainWater;

import java.util.Arrays;

public class Solution {
    public int trap(int[] height) {
        int len = height.length;
        if(len==0) return 0;
        int[]maxLeft = new int[len];
        int[]maxRight = new int[len];
        int result=0;
        maxLeft[0]=height[0];
        for(int i = 1; i<len; i++) {
            maxLeft[i] = Math.max(maxLeft[i-1],height[i]);
        }
        maxRight[len-1]=height[len-1];
        for(int i = len-2; i>=0; i--) {
            maxRight[i] = Math.max(maxRight[i+1],height[i]);
        }
        for(int i = 0; i<len; i++) {
            result+=Math.min(maxLeft[i],maxRight[i])-height[i];
        }
        return result;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(Arrays.toString(height));
        System.out.println(s.trap(height));
    }
}
