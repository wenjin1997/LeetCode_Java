/**
 * @author 文进
 * @version 1.0
 * 279.完全平方数
 */
public class N279_Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1]; // dp 数组
        for (int i = 1; i <= n; i++) {
            int minn = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                minn = Math.min(minn, dp[i - j * j]);
            }
            dp[i] = minn + 1;
        }
        return dp[n];
    }
}
