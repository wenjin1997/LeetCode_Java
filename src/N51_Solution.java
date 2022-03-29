import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 文进
 * @version 1.0
 * 51.N皇后
 */
public class N51_Solution {
    public static void main(String[] args) {
        N51_Solution n51_solution = new N51_Solution();
        List<List<String>> res = n51_solution.solveNQueens(4);
        System.out.println(res);
    }

    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        // '.' 表示空，'Q'表示皇后，初始化空棋盘
        ArrayList<String> board = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(".");
            }
            board.add(sb.toString());
        }
        backtrack(board, 0);
        return res;
    }

    /*
    路径：board 中小于 row 的那些行都已经成功放置了皇后
    选择列表：第 row 行的所有列都是放置皇后的选择
    结束条件： row 超过 board 的最后一行
     */
    void backtrack(ArrayList<String> board, int row) {
        // 触发结束条件
        if (row == board.size()) {
            res.add(new ArrayList<>(board));
            return;
        }

        int n = board.get(row).length();
        for (int col = 0; col < n; col++) {
            char[] rows = new char[n];
            Arrays.fill(rows, '.');
            // 排除不合法的选择
            if (!isValid(board, row, col)) {
                continue;
            }
            // 做选择
            rows[col] = 'Q';
            board.set(row, new String(rows));
            // 进行下一行决策
            backtrack(board, row + 1);
            // 撤销选择
            rows[col] = '.';
            board.set(row, new String(rows));
        }

    }

    /*
    是否可以在 board[row][col] 放置皇后？
     */
    boolean isValid(List<String> board, int row, int col) {
        int n = board.size();
        // 检查列是否有皇后冲突
        for (int i = 0; i < n; i++) {
            if (board.get(i).charAt(col) == 'Q') {
                return false;
            }
        }
        // 检查右上方是否有皇后互相冲突
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        // 检查左上方是否有皇后互相冲突
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        return true;
    }
}