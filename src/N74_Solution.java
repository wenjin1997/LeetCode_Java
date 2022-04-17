/**
 * @author 文进
 * @version 1.0
 * 74.搜索二维矩阵
 */
public class N74_Solution {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
//        int[][] matrix = new int[][]{{1,3}};
        int target = 11;
        N74_Solution n74_solution = new N74_Solution();
        System.out.println(n74_solution.searchMatrix(matrix, target));
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        // 先用二分搜索找到在第 x 行
        int rowIndex = 0;
        int leftRow = 0, rightRow = m - 1;
        while (leftRow < rightRow - 1) {
            int mid = leftRow + (rightRow - leftRow) / 2;
            if (matrix[mid][0] < target) {
                leftRow = mid;
            } else if (matrix[mid][0] > target) {
                rightRow = mid - 1;
            } else {
                return true;
            }
        }
        rowIndex = leftRow;
        // 有可能在第 X + 1 行
        if (rowIndex + 1  < m && matrix[rowIndex + 1][0] <= target) {
            rowIndex++;
        }
        // 再用二分搜索在 rowIndex 行进行搜索
        int leftCol = 0, rightCol = n - 1;
        while (leftCol <= rightCol) {
            int mid = leftCol + (rightCol - leftCol) / 2;
            if (matrix[rowIndex][mid] < target) {
                leftCol = mid + 1;
            } else if (matrix[rowIndex][mid] > target) {
                rightCol = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
