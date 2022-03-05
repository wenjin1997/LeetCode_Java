/**
 * @author 文进
 * @version 1.0
 * 714.买卖股票的最佳时机含手续费
 */
public class N714_Solution {
    // 原始版本
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i - 1 == -1) {
                // base case
                dp[i][0] = 0;
                // dp[i][1]
                //      = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee)
                //      = Math.max(dp[-1][1], dp[-1][0] - prices[i] - fee)
                //      = Math.max(- infinity, 0 - prices[i] - fee)
                //      = - prices[i] - fee
                dp[i][1] = - prices[i] - fee;
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee);
        }
        return dp[n - 1][0];
    }

    // 空间优化版本
    int maxProfit_with_fee(int[] prices, int fee) {
        int n = prices.length;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, temp - prices[i] - fee);
        }
        return dp_i_0;
    }
}
