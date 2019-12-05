package LeetCode.Q123BestTimetoBuyandSellStockIII;

import LeetCode.Utility.*;

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length<=1) return 0;
        int[] dp = new int[prices.length];
        int maxRight = prices[prices.length-1];
        for (int i = prices.length-2; i >= 0; i--) {
            if(prices[i]<maxRight) {
                dp[i]=maxRight-prices[i];
            } else {
                maxRight=prices[i];
            }
        }
        int minLeft = prices[0];
        int maxLeftProfit = 0;
        int totalProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i]-minLeft;
            if(prices[i]<prices[i-1]) totalProfit = Math.max(totalProfit,maxLeftProfit+dp[i]);
            if(profit<0) minLeft=prices[i];
            else if(profit>maxLeftProfit) maxLeftProfit=profit;
        }
        return Math.max(totalProfit,maxLeftProfit);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] prices = {3,3,5,0,0,3,1,4};
        System.out.println(s.maxProfit(prices));
    }
}
