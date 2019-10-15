package LeetCode.Q456_132Pattern;

public class SolutionWithoutStack {
    public boolean find132pattern(int[] nums) {
        if (nums.length == 0) return false;
        int[] minI = new int[nums.length];
        minI[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            minI[i] = Math.min(minI[i - 1], nums[i]);
        }
        int top = nums.length - 1;
        for (int j = nums.length - 2; j >= 1; j--) {
            if (nums[j] > minI[j]) {
                while (top < nums.length && nums[top] <= minI[j]) top++;
            }
            if (top < nums.length && nums[j] > nums[top]) return true;
            nums[--top] = nums[j];
        }
        return false;
    }

    public static void main(String[] args) {
        SolutionWithoutStack s = new SolutionWithoutStack();
        int[] nums = {3,1,4,2};
        System.out.println(s.find132pattern(nums));
        nums = new int[]{1, 2, 3, 4};
        System.out.println(s.find132pattern(nums));
        nums = new int[]{1,0,1,-4,-3};
        System.out.println(s.find132pattern(nums));
        nums = new int[]{3,5,0,3,4};
        System.out.println(s.find132pattern(nums));    }
}

