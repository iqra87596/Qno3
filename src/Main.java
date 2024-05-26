package com.company;
import java.util.Arrays;
public class Main {
    public static int minCoinsUtil(int[] coins, int m, int V, int[] dp) {
        if (V == 0)
            return 0;
        if (dp[V] != -1)
            return dp[V];
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            if (coins[i] <= V) {
                int sub_res = minCoinsUtil(
                        coins, m, V - coins[i], dp);
                if (sub_res != Integer.MAX_VALUE
                        && sub_res + 1 < res)
                    res = sub_res + 1;
            }
        }
        dp[V] = res;
        return res;
    }
    public static int minCoins(int[] coins, int m, int V)
    {
        int[] dp = new int[V + 1];
        Arrays.fill(dp, -1);
        return minCoinsUtil(coins, m, V, dp);
    }
    public static void main(String[] args)
    {
        int[] coins = { 100,500, 1000, 5000, 2,5,1 };
        int m = coins.length;
        int V = 1988;
        int res = minCoins(coins, m, V);
        if (res == Integer.MAX_VALUE)
            res = -1;
        System.out.println("Minimum coins required is "
                + res);
    }
}