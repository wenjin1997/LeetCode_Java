class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        // base case
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        boolean found = false;
        int rows = matrix.length;
        int cols = matrix[0].length;
        // 从数组的右上角开始遍历
        int row = 0, col = cols - 1;
        while (row < rows && col >= 0) {
            if (matrix[row][col] == target) {
                found = true;
                break;
            } else if (matrix[row][col] > target) {
                // 删除当前元素所在的列
                col--;
            } else {
                // 删除当前元素所在的行
                row++;
            }
        }
        return found;
    }
}