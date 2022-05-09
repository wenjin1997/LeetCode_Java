/*
 * @lc app=leetcode.cn id=59 lang=java
 *
 * [59] 螺旋矩阵 II
 */

// @lc code=start
class Solution {
    public int[][] generateMatrix(int n) {
        int upperBound = 0, lowerBound = n - 1;
        int leftBound = 0, rightBound = n - 1;
        int[][] matrix = new int[n][n];
        int num = 1;
        while (num <= n * n) {
            // 在顶部，从左向右添加元素
            if (upperBound <= lowerBound) {
                for (int i = leftBound; i <= rightBound; i++) {
                    matrix[upperBound][i] = num;
                    num++;
                }
                upperBound++;
            }

            // 在最右边，从上向下添加元素
            if (rightBound >= leftBound) {
                for (int i = upperBound; i <= lowerBound; i++) {
                    matrix[i][rightBound] = num;
                    num++;
                }
                rightBound--;
            }

            // 在最下方，从右向左添加元素
            if (lowerBound >= upperBound) {
                for (int i = rightBound; i >= leftBound; i--) {
                    matrix[lowerBound][i] = num;
                    num++;
                }
                lowerBound--;
            }

            // 在最左边，从下向上添加元素
            if (leftBound <= rightBound) {
                for (int i = lowerBound; i >= upperBound; i--) {
                    matrix[i][leftBound] = num;
                    num++;
                }
                leftBound++;
            }
        }
        return matrix;
    }
}
// @lc code=end

