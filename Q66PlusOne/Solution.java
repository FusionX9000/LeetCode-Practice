package LeetCode.Q66PlusOne;

import java.util.Arrays;

public class Solution {
    public int[] plusOne(int[] digits) {
        if(digits.length==0) return digits;
        int num = digits[digits.length-1]+1;
        int carry = num/10;
        digits[digits.length-1] = num%10;
        int i = digits.length-1;
        while(--i >=0 && carry!=0) {
            digits[i]+=carry;
            carry = digits[i]/10;
            digits[i]%=10;
        }
        if(carry!=0) {
            digits = new int[digits.length+1];
            digits[0] = 1;
        }
        return digits;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] digits = {9,9,9,9};
        System.out.println(Arrays.toString(s.plusOne(digits)));
    }
}
