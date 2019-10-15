package LeetCode.Q11ContainerWithMostWater;

class Solution {
//    public int maxArea(int[] height) {
//        int[]maxLeft = new int[height.length];
//        int[]maxRight = new int[height.length];
//        int result=0;
//        maxLeft[0]=height[0];
//        maxRight[height.length-1]=height[height.length-1];
//        for(int i = 1; i<height.length; i++) {
//            maxLeft[i] = Math.max(maxLeft[i-1],height[i]);
//        }
//        for(int i = height.length-2; i>0; i--) {
//            maxRight[i] = Math.max(maxRight[i-1],height[i]);
//        }
//        for(int i = 0; i<height.length; i++) {
//            result+=Math.min(maxLeft[i],maxRight[i])-height[i];
//        }
//        return result;
//    }
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int max = 0;
        while(left<right) {
            max = Math.max(max,Math.min(height[left],height[right])*(right-left));
//            int water = Math.min(height[left],height[right])*(right-left);
//            if(water>max) max=water;
            if(height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxArea(new int[] {1,8,6,2,5,4,8,3,7}));
    }
}
