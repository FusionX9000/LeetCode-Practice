package LeetCode.Q43MultiplyStrings;

import java.util.Arrays;

public class Solution {
    public String multiply(String num1, String num2) {
        int[] products = new int[num1.length()+num2.length()];
        for(int i = num1.length()-1; i>=0; i--) {
            int a = num1.charAt(i)-'0';
            for(int j = num2.length()-1; j>=0; j--) {
                int mult = (num2.charAt(j)-'0') * a;
                int last = i+j+1, slast = i+j;
                int sum = products[last]+mult;
                products[last] = sum%10;
                products[slast]+= sum/10;
            }
        }
        System.out.println(Arrays.toString(products));
        StringBuilder ans = new StringBuilder();
        int i = 0;
        while(i<products.length && products[i]==0) i++;
        for(;i<products.length;i++) {
            ans.append(products[i]);
        }
        return ans.toString().length()==0 ? "0" : ans.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String num1 = "256";
        String num2 = "";
        System.out.println(s.multiply(num2,num1));
    }
}
