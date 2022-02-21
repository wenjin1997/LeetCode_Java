import java.util.Arrays;

/**
 * @author 文进
 * @version 1.0
 * 931.下降路径最小和
 */
public class N931_Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int res = Integer.MAX_VALUE;
        // 备忘录里的值初始化为66666
        memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], 66666);
        }
        // 终点可能在matrix[n-1]的任意一列
        for (int j = 0; j < n; j++) {
            res = Math.min(res, dp(matrix, n - 1, j));
        }
        return res;
    }

    // 备忘录
    int[][] memo;

    int dp(int[][] matrix, int i, int j) {
        // 索引合法性检查
        if (i < 0 || j < 0 ||
                i >= matrix.length ||
                j >= matrix[0].length) {
            return 99999;
        }

        // base case
        if (i == 0) {
            return matrix[0][j];
        }

        // 查找备忘录，防止重复计算
        if (memo[i][j] != 66666) {
            return memo[i][j];
        }

        // 进行状态转移，上一行中三个数求最小，再加上该数
        memo[i][j] = matrix[i][j] +
                Math.min(Math.min(dp(matrix, i - 1, j), dp(matrix, i - 1, j - 1)),
                        dp(matrix, i - 1, j + 1));
        return memo[i][j];
    }
}
