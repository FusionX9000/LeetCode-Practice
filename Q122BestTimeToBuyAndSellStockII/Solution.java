package LeetCode.Q122BestTimeToBuyAndSellStockII;

import LeetCode.Utility.*;

import java.util.Arrays;

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length==0) return 0;
        int minLeft = prices[0];
        int result = 0;
        for (int i = 0; i < prices.length-1; i++) {
            if(prices[i]>prices[i+1]) {
                result+=(prices[i]-minLeft);
                minLeft = prices[i+1];
            }
        }
        result+=Math.max(0,prices[prices.length-1]-minLeft);
        return result;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] prices = {8,10,11,12,5,7,3,15};
        System.out.println(s.maxProfit(prices));
    }
}
