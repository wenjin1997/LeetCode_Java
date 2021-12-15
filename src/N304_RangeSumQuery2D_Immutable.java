/**
 * @author 文进
 * @version 1.0
 * 304.二维区域和检索-矩阵不可变
 * 思路：利用前缀和矩阵
 *      右下角的矩阵和 = 整个矩阵和 - 左下角矩阵和 - 右上角矩阵和 + 左上角矩阵和
 */
public class N304_RangeSumQuery2D_Immutable {
}

class NumMatrix {
    private int[][] preSum; // 前缀和矩阵

    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (m == 0 || n == 0) return;
        preSum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] +
                        matrix[i - 1][j - 1] - preSum[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preSum[row2 + 1][col2 + 1] - preSum[row1][col2 + 1] - preSum[row2 + 1][col1] + preSum[row1][col1];

    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
