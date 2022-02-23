/**
 * @author 文进
 * @version 1.0
 * 72.编辑距离
 */
public class N72_Solution {
    // 自底向上的动态规划方法
    public int minDistance(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        // 定义：s1[0...i] 和 s2[0...j] 的最小编辑距离是 dp[i-1][j-1]
        int[][] dp = new int[m + 1][n + 1];
        // base case
        for (int i = 1; i <= m; i++) {
            // s2的指针到最开始了，但s1还有，则全部进行i次删除操作
            dp[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            // s1到最开始了，但s2还有，则全部进行j次插入操作
            dp[0][j] = j;
        }
        // 自底向上求解
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; // 什么也不做，跳过
                } else {
                    dp[i][j] = min(
                            dp[i - 1][j] + 1,    // 删除
                            dp[i][j - 1] + 1,    // 插入
                            dp[i - 1][j - 1] + 1 // 替换
                    );
                }
            }
        }
        // 存储着整个 s1 和 s2 的最小编辑距离
        return dp[m][n];
    }

    int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
