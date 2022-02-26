import java.util.Arrays;

/**
 * @author 文进
 * @version 1.0
 * 712.两个字符串的最小ASCII删除和
 * 思路：和求最长公共子序列思路类似，不过需要修改原来的代码，
 *      为了计算ASCII删除和
 */
public class N712_Solution {
    int[][] memo; // 备忘录
    public int minimumDeleteSum(String s1, String s2) {
        // 初始化备忘录
        memo = new int[s1.length()][s2.length()];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dp(s1, 0, s2, 0);
    }

    int dp(String s1, int i, String s2, int j) {
        int res = 0; // 记录删除的ASCII码和的值
        // base case
        if (i == s1.length()) {
            // 此时需要删除s2中剩下的所有字符
            for (; j < s2.length(); j++) {
                res += s2.charAt(j);
            }
            return res;
        }
        if (j == s2.length()) {
            // 如果 s2 到头了，需要删除 s1 剩下的所有字符
            for (; i < s1.length(); i++) {
                res += s1.charAt(i);
            }
            return res;
        }

        // 防止重复计算
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        // 状态转移
        if (s1.charAt(i) == s2.charAt(j)) {
            memo[i][j] = dp(s1, i + 1, s2, j + 1);
        } else {
            memo[i][j] = Math.min(
                    dp(s1, i + 1, s2, j) + s1.charAt(i),
                    dp(s1, i, s2, j + 1) + s2.charAt(j)
            );
        }
        return memo[i][j];
    }
}