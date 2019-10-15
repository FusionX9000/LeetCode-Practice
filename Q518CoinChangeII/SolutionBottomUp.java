package LeetCode.Q518CoinChangeII;

import java.util.Arrays;

/*
Cache 2D dp->
ith row is the number of ways to make amount in jth row using first ith coins.
    f(i,j) = f(i-1,j) + f(i,j-C[i])
    f(0,x) for x>0 = 0
    f(x,0) = 1

 */

public class SolutionBottomUp {
    public int change(int amount, int[] coins) {
        int[][] cache = new int[coins.length + 1][amount + 1];
        cache[0][0] = 1;
        for (int i = 1; i <= coins.length; i++) {
            cache[i][0] = 1;
            int coin = coins[i - 1];
            for (int amt = 1; amt <= amount; amt++) {
                cache[i][amt] = cache[i - 1][amt] + (amt - coin >= 0 ? cache[i][amt - coin] : 0);
            }
        }
        return cache[coins.length][amount];
    }

    //1D DP
    public int change2(int amount, int[] coins) {
        int[] cache = new int[amount + 1];
        cache[0] = 1;
        for (int i = 1; i <= coins.length; i++) {
            int coin = coins[i-1];
            for (int amt = coin; amt <= amount; amt++) {
                cache[amt] = cache[amt] + cache[amt-coin];
            }
        }
        System.out.println(Arrays.toString(cache));
        return cache[amount];
    }

    public static void main(String[] args) {
        SolutionBottomUp s = new SolutionBottomUp();
        int[] coins = {1, 2, 5};
        int amount = 5;
        System.out.println(s.change2(amount, coins));
    }
}
