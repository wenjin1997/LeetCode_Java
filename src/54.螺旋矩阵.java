/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 */

// @lc code=start
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int upperBound = 0, rightBound = n - 1;
        int downBound = m - 1, leftBound = 0;

        List<Integer> res = new ArrayList<>();
        while (res.size() < m * n) {
            // 在顶部，从左遍历到右
            if (upperBound <= downBound) {
                for (int i = leftBound; i <= rightBound; i++) {
                    res.add(matrix[upperBound][i]);
                }
                upperBound++;
            }

            // 在最右边，从上遍历到下
            if (rightBound >= leftBound) {
                for (int i = upperBound; i <= downBound; i++) {
                    res.add(matrix[i][rightBound]);
                }
                rightBound--;
            }

            // 在最下边，从右遍历到左
            if (downBound >= upperBound) {
                for (int i = rightBound; i >= leftBound; i--) {
                    res.add(matrix[downBound][i]);
                }
                downBound--;
            }

            // 在最左边，从下遍历到上
            if (leftBound <= rightBound) {
                for (int i = downBound; i >= upperBound; i--) {
                    res.add(matrix[i][leftBound]);
                }
                leftBound++;
            }
        }
        return res;
    }
}
// @lc code=end

