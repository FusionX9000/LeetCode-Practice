package LeetCode.Q9PalindromeNumber;

class Solution {
// WHAT THE FUCK IS THIS??!?!
//    public boolean isPalindrome(int x) {
//        if(x<0) return false;
//        int first = (int)(Math.log(x)/Math.log(10));
//        int last = 0;
//        while(first>=last) {
//            int firstN = (x/(int)Math.pow(10,first))%10;
//            int lastN = x/(int)Math.pow(10,last)%10;
//            if(firstN!=lastN) {
//                return false;
//            }
//            first--;
//            last++;
//        }
//        return true;
//    }
    public boolean isPalindrome(int x) {
        if(x<0 || (x%10==0 && x!=0)) return false;
        int revertedNumber = 0;
        while(x>revertedNumber) {
            revertedNumber = revertedNumber*10 + x%10;
            x/=10;
        }
        if(x==revertedNumber || x==revertedNumber/10) return true;
        return false;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isPalindrome(1001));
    }
}
