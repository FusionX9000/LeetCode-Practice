package LeetCode.Q8StringToInteger;

class Solution {
    public int myAtoi(String str) {
        if(str.length()==0) {
            return 0;
        }
        int result = 0;
        int sign = 1;

        int i = 0;
        while(i<str.length() && str.charAt(i)==' ') {
            i++;
        }
        if (isSign(str.charAt(i))) {
            sign = str.charAt(i) == '-' ? -1 : 1;
            i++;
        }
        for (; i<str.length(); i++) {
            char c = str.charAt(i);
            if (invalidCharacter(c)) break;
            int digit = c - '0';
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE/10 && digit > Integer.MAX_VALUE%10)) {
                return Integer.MAX_VALUE;
            }
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE/10 && digit > Integer.MAX_VALUE%10)) {
                return Integer.MIN_VALUE;
            }
            result = result * 10 + sign * digit;
        }
        return result;
    }
    private boolean isSign(char c) {
        if(c=='-' || c=='+') return true;
        return false;
    }
    private boolean invalidCharacter(char c) {
        if(c>='0' && c<='9') {
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.myAtoi("  -42 a"));
    }
}
