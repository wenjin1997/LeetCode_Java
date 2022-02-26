import java.util.Arrays;

/**
 * @author 文进
 * @version 1.0
 * 583.两个字符串的删除操作
 *     将此题转换为1143.最长公共子序列
 */
public class N583_Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int lcs = longestCommonSubsequence(word1, word2);
        return n - lcs + m - lcs;
    }

    // 问题1143，最长公共子序列
    int[][] memo;
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        memo = new int[n][m];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dp(text1, 0, text2, 0);
    }

    int dp(String s1, int i, String s2, int j) {
        int n = s1.length(), m = s2.length();
        if (i == n || j == m) {
            return 0;
        }

        // 防止重复计算
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        // 状态转移
        if (s1.charAt(i) == s2.charAt(j)) {
            memo[i][j] = dp(s1, i + 1, s2, j + 1) + 1;
        } else {
            memo[i][j] = Math.max(
                    dp(s1, i + 1, s2, j),
                    dp(s1, i, s2, j + 1)
            );
        }
        return memo[i][j];
    }
}
