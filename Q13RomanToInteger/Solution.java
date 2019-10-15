package LeetCode.Q13RomanToInteger;


public class Solution {
    public int getVal(char s) {
        switch(s) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
    public int romanToInt(String s) {
        int result = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            char ch = s.charAt(i);
            if (getVal(ch) >= getVal(s.charAt(i + 1))) {
                result += getVal(ch);

            } else {
                result -= getVal(ch);
            }
        }
        result += getVal(s.charAt(s.length() - 1));
        return result;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.romanToInt("MCMXCIV"));
    }
}
