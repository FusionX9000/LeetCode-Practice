package LeetCode.Q121BestTimetoBuyandSellStock;

import LeetCode.Utility.*;

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length == 0) {
            return 0;
        }
        int maxDiff = 0;
        int minLeft = prices[0];
        for (int price : prices) {
            if(price-minLeft>maxDiff) {
                maxDiff = price-minLeft;
            }
            if(price<minLeft) minLeft = price;
        }
        return maxDiff;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] prices = {4,4,4,4,5};
        System.out.println(s.maxProfit(prices));
    }
}
