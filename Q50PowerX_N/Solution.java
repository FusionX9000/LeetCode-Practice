package LeetCode.Q50PowerX_N;

public class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            if(n == Integer.MIN_VALUE) {
                n/=2;
                x*=x;
            }
            x = 1 / x;
            n *= -1;
        }
        return n%2==0 ? myPow(x*x,n/2) : x*myPow(x*x,n/2);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.myPow(2,Integer.MIN_VALUE));
    }
}
