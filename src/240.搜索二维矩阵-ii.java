/*
 * @lc app=leetcode.cn id=240 lang=java
 *
 * [240] 搜索二维矩阵 II
 */

// @lc code=start
class Solution {
    // 剑指Offer 第4题
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        boolean found = false;
        int m = matrix.length, n = matrix[0].length;
        // 从右上开始搜索
        int row = 0, col = n - 1;
        while (row < m && col >= 0) {
            int curElement = matrix[row][col];
            if (curElement > target) {
                col--;
            } else if (curElement < target) {
                row++;
            } else {
                found = true;
                break;
            }
        }
        return found;
    }
}
// @lc code=end

