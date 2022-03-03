import java.util.Arrays;
import java.util.HashMap;

/**
 * @author 文进
 * @version 1.0
 * 44.通配符匹配
 * 思路：和第10题类似，注意为防止超出内存限制
 *      这里的备忘录不能取成 HashMap<String, Boolean>
 *      而是int[][] dp
 *      原因是避免测试用例中字符串长度非常大，这样HashMap中键的
 *      存储占用过多，而直接用二维数组，存储占用小
 */
public class N44_Solution {
    public static void main(String[] args) {
        String s = "acdcb";
        String p = "a*c?b";
        N44_Solution solution = new N44_Solution();
        System.out.println(solution.isMatch(s, p));
    }
    public boolean isMatch(String s, String p) {
        memo = new int[s.length()][p.length()];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dp(s, 0, p, 0);
    }
    // 备忘录, -1 表示还未计算， 0 表示 false， 1 表示 true。
    int[][] memo;
    /* s[i...] 和 p[j...] 是否匹配 */
    boolean dp(String s, int i, String p, int j) {
        int m = s.length(), n = p.length();

        // base case
        if (j == n) {
            return i == m;
        }
        if (i == m) {
            // 看字符串 p 是否匹配空串
            // 只要 p 中是连续的'*'或只有一个'*'就能匹配空串
            for (; j < n; j++) {
                if (p.charAt(j) != '*') {
                    return false;
                }
            }
            return true;
        }

        // 防止重复计算
        if (memo[i][j] != -1) {
            return memo[i][j] == 1;
        }

        // 状态转移
        boolean res = false;
        if (s.charAt(i) == p.charAt(j)) {
            // 字符相当，继续向后匹配
            res = dp(s, i + 1, p, j + 1);
        } else {
            // 字符不相等
            if (p.charAt(j) == '*') {
                // 通配符，可以匹配空串，也可以继续匹配后序字符串
                // dp(s, i + 1, p, j) 表示继续匹配
                // dp(s, i, p, j + 1) 表示匹配空字符串
                res = dp(s, i + 1, p, j) || dp(s, i, p, j + 1);
            } else if (p.charAt(j) == '?') {
                // '?'匹配单个字符，然后继续匹配
                res = dp(s, i + 1, p, j + 1);
            } else {
                res = false;
            }
        }
        memo[i][j] = res ? 1 : 0;
        return res;
    }
}
