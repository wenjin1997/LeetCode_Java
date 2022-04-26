/*
 * @lc app=leetcode.cn id=304 lang=java
 *
 * [304] 二维区域和检索 - 矩阵不可变
 */

// @lc code=start
class NumMatrix {
    int[][] preMatrixSum; // 前缀和矩阵

    public NumMatrix(int[][] matrix) {
        int m = matrix.length; // 行数
        int n = matrix[0].length; // 列数
        if (m == 0 || n == 0) return;
        preMatrixSum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                preMatrixSum[i][j] = preMatrixSum[i - 1][j] + preMatrixSum[i][j - 1] + matrix[i - 1][j - 1] - preMatrixSum[i - 1][j - 1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preMatrixSum[row2 + 1][col2 + 1] - preMatrixSum[row2 + 1][col1] - preMatrixSum[row1][col2 + 1] + preMatrixSum[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
// @lc code=end

