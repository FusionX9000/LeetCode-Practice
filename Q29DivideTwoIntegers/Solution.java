package LeetCode.Q29DivideTwoIntegers;

public class Solution {
    //    public int divide(int dividend, int divisor) {
//        int sign = findSign(dividend)^findSign(divisor);
//        int c = 0;
//        if(dividend == Integer.MIN_VALUE) {
//            if(divisor==-1) return Integer.MAX_VALUE;
//            if(divisor==1) return dividend;
//            else return ((divisor&1)==1)?divide(dividend+1,divisor):divide(dividend>>1,divisor>>1);
//
//        }
//        if(divisor==Integer.MIN_VALUE) return 0;
//        dividend=abs(dividend);
//        divisor=abs(divisor);
//        if(dividend>=divisor) {
//            while(dividend-divisor>=0) {
//                int i=0;
//                for(i = 0; dividend - (divisor<<i) >=0; i++);
//                i=i-1;
//                c+= 1<<i;
//                dividend -= divisor<<i;
//            }
//        } else {
//            return 0;
//        }
//        return sign==0 ? c : invertSign(c);
//    }
//    public int invertSign(int n) {
//        return ~(n-1);
//    }
//    public int findSign(int n) {
//        return n>>31 == -1 ? -1 : 1;
//    }
//    public int abs(int n) {
//        return findSign(n)==1 ? n : invertSign(n);
//    }
    public int divide(int dividend, int divisor) {
        int sign = (dividend >= 0) == (divisor >= 0) ? 0 : 1;
        int c = 0;
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1) return Integer.MAX_VALUE;
            if (divisor == 1) return dividend;
            dividend+=Math.abs(divisor);
            c++;
//          return ((divisor & 1) == 1) ? (divide(dividend + 1, divisor) + divide(-1, divisor)) : divide(dividend >> 1, divisor >> 1);
        }
        if (divisor == Integer.MIN_VALUE) return 0;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        if (dividend >= divisor) {
            while (dividend - divisor >= 0) {
                int i = 0;
                for (i = 0; dividend - (divisor << i) >= 0; i++) ;
                i = i - 1;
                c += 1 << i;
                dividend -= divisor << i;
            }
        } else {
            return 0;
        }
        return sign == 0 ? c : invertSign(c);
    }

    public int invertSign(int n) {
        return ~(n - 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int n1 = Integer.MIN_VALUE;
        int n2 = 2;
        System.out.println(n1 + " / " + n2);
        int ans = s.divide(n1, 3);
        System.out.println(ans);
        System.out.println(n1/3==ans);
    }
}
