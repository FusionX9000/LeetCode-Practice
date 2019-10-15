package LeetCode.Q322CoinChange;

import java.util.HashMap;

public class Solution {
    int[] cache;
    int count = 0;
//    public int coinChange(int[] coins, int amount) {
//        return coinChange(coins, 0, amount);
//    }

//    public int coinChange(int[] coins, int pos, int amount) {
//        count++;
//        System.out.println(pos + " " + amount);
//
//        String key = String.valueOf(pos) + amount;
//        if (cache.containsKey(key)) return cache.get(key);
//
//        if (pos == coins.length) {
//            if (amount == 0) return 0;
//            return -1;
//        }
//
//        int n = 0;
//        int leastCoins = -1;
//        while (coins[pos] * n <= amount) {
//            int curr = coinChange(coins, pos + 1, amount - (coins[pos]*n));
//            if (curr != -1 && (leastCoins == -1 || curr + n < leastCoins)) leastCoins = curr + n;
//            n++;
//        }
//        cache.put(key,leastCoins);
//        return leastCoins;
//    }

    public int coinChange(int[] coins, int amount) {
        return coinChange(coins,amount, new int[amount+1]);
    }

    public int coinChange(int[] coins, int amount,int[] cache) {
        count++;
        if (amount < 0) return -1;
        if (amount == 0) return 0;

        if (cache[amount]!=0) return cache[amount];

        int leastCoins = Integer.MAX_VALUE;

        for (int coin : coins) {
            int next = coinChange(coins, amount - coin,cache);
            if (next >= 0) leastCoins = Math.min(next + 1, leastCoins);
        }
        if (leastCoins == Integer.MAX_VALUE) cache[amount] = -1;
        else cache[amount] = leastCoins;
        return cache[amount];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] coins = {186,419,83,408};
        int amount = 6249;
        System.out.println(s.coinChange(coins, amount));
        System.out.println(s.count);
    }
}
