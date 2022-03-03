/**
 * @author 文进
 * @version 1.0
 * 121.买卖股票的最佳时机
 * 买卖股票问题
 * 通用方法：i 表示第 i 天，k 表示剩余交易次数，0 表示没有持有股票， 1 表示持有股票
 *         dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
 *         dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k][0] - prices[i]);
 * base case:
 *      dp[-1][...][0] = 0
 *      dp[-1][...][1] = -infinity
 *      dp[...][0][0] = 0
 *      dp[...][0][1] = -infinity
 * 本题中 k = 1
 */
public class N121_Solution {
    // 原始版本
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i - 1 == -1) {
                // base case
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[n - 1][0];
    }

    // 空间复杂度优化版本
    int maxProfit_k_1(int[] prices) {
        int n = prices.length;
        // base case: dp[-1][0] = 0, dp[-1][1] = -infinity
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            // dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            // dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            dp_i_1 = Math.max(dp_i_1, -prices[i]);
        }
        return dp_i_0;
    }
}
