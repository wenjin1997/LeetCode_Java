/*
 * @lc app=leetcode.cn id=48 lang=java
 *
 * [48] 旋转图像
 */

// @lc code=start
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 先做镜像对称
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // 交换 (i, j) 与 (j, i) 的元素
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 对调每一行
        for (int[] row : matrix) {
            for (int j = 0; j < n / 2; j++) {
                int temp = row[j];
                row[j] = row[n - 1 - j];
                row[n - 1 - j] = temp;
            }
        }
    }
}
// @lc code=end

