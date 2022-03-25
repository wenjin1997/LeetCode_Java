/**
 * @author 文进
 * @version 1.0
 * 52.N皇后II
 * 方法：回溯法，解法和 51.N皇后 相同
 */
public class N52_Solution {
    int res = 0;
    public int totalNQueens(int n) {
        int[][] board = new int[n][n];
        backtrack(board, 0);
        return res;
    }

    /*
    棋盘 board: 1 表示皇后， 0 表示空
     */
    void backtrack(int[][] board, int row) {
        // 达到结束条件
        if (board.length == row) {
            res++;
            return;
        }
        int n = board.length;
        for (int col = 0; col < n; col++) {
            if (!canPutQueen(board, row, col)) {
                continue;
            }
            // 做选择
            board[row][col] = 1;
            // 回溯
            backtrack(board, row + 1);
            // 撤回选择
            board[row][col] = 0;
        }
    }

    boolean canPutQueen(int[][] board, int row, int col) {
        int n = board.length;
        // 检查所在的列
        for (int i = 0; i < n; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }
        // 检查斜对角 右上方
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // 检查斜对角 左上方
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }
}
