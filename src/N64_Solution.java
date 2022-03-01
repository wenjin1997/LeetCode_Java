import java.util.Arrays;

/**
 * @author 文进
 * @version 1.0
 * 64.最小路径和
 * 思路：动态规划的方法
 */
public class N64_Solution {
    int[][] memo; // 备忘录
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // 备忘录初始化
        memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dp(grid, m - 1, n - 1);
    }

    int dp(int[][] grid, int i, int j) {
        // 防止越界
        if (i < 0 || j < 0 ) {
            return Integer.MAX_VALUE;
        }

        // base case
        if(i == 0 && j == 0) {
            return grid[0][0];
        }

        // 防止重复计算
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        // 状态转移
        memo[i][j] = grid[i][j] + Math.min(dp(grid, i - 1, j),
                dp(grid, i, j - 1));
        return memo[i][j];
    }
}
