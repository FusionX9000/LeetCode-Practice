package LeetCode.Q12IntegerToRoman;

import java.util.HashMap;

public class Solution {
    public String roman(int n) {
        if (n > 3999) {
            return "";
        }
        HashMap<Integer, Character> map = new HashMap<>();
        int[] num = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] str = new String[]{"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        StringBuilder result = new StringBuilder();
        for (int i = num.length - 1; i >= 0; i--) {
            while (n / num[i] > 0) {
                n = n - num[i];
                result.append(str[i]);
            }
        }
        return result.toString();
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.roman(3999));
    }
}
