package LeetCode.Q322CoinChange;

public class SolutionBottomUp {
    public int coinChange(int[] coins, int amount) {
        int[] cache = new int[amount+1];
        for (int amt = 1; amt <= amount; amt++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if(coins[j]<=amt) {
                    int prev = cache[amt-coins[j]];
                    if(prev>=0)  min = Math.min(min,prev+1);
                }
            }
            cache[amt] = min==Integer.MAX_VALUE ? -1 : min;
        }
        return cache[amount];
    }

    public static void main(String[] args) {
        SolutionBottomUp s = new SolutionBottomUp();
        int[] coins = {123,2,5};
        int amount = 0;
        System.out.println(s.coinChange(coins, amount));
    }
}
