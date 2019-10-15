package LeetCode.Q518CoinChangeII;

public class Solution {
    public int change(int amount, int[] coins) {
        Integer[][] cache = new Integer[coins.length][amount+1];
        int res = change(amount, coins, 0, cache);
        return res;
    }

    public int change(int amount, int[] coins, int pos, Integer [][] cache) {
        if (pos == coins.length) {
            if (amount == 0) return 1;
            else return 0;
        }
        if (cache[pos][amount]!=null) return cache[pos][amount];

        int ways = 0;

        for (int amt = amount; amt>=0 ; amt -= coins[pos]) {
            ways += change(amt, coins, pos + 1, cache);
        }
        return cache[pos][amount]=ways;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] coins = {1,2,5};
        int amount = 5;
        System.out.println(s.change(amount, coins));
    }
}
