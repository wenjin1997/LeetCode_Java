/**
 * @author 文进
 * @version 1.0
 * 518.零钱兑换II
 * 思路：由于每种硬币的个数是无限的，这是一个完全背包问题
 *      明确dp数组的含义，用动态规划
 *      若只使用coins中前i个硬币的面值，若想凑出金额j，有dp[i][j]种凑法
 */
public class N518_Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        // 若只使用coins中前i个硬币的面值，若想凑出金额j，有dp[i][j]种凑法
        int[][] dp = new int[n + 1][amount + 1];
        // base case
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        // 状态转移
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i - 1] >= 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][amount];
    }

    // 对方法一空间上做了优化，dp数组压缩成一维
    int change2(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1; // base case
        // 状态转移
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j - coins[i] >= 0) {
                    dp[j] = dp[j] + dp[j - coins[i]];
                }
            }
        }
        return dp[amount];
    }
}
