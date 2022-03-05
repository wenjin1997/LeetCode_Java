/**
 * @author 文进
 * @version 1.0
 * 91.解码方法
 * 思路：动态规划方法
 *      dp[i] 表示 s[0,...,i-1] 的解码方法的个数
 *      如果 s[i - 1] 可以组成一个字符，则 dp[i] = dp[i - 1]
 *      如果 s[i - 1] 和 s[i - 2] 可以组成两个字符，则 dp[i] = dp[i - 2]
 *      base case: dp[0] = 1
 */
public class N91_Solution {
    public static void main(String[] args) {
        String s = "226";
        N91_Solution solution = new N91_Solution();
        System.out.println(solution.numDecodings(s));
    }
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        // base case
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) != '0' && (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }

    // 空间复杂度优化
    public int numDecodings2(String s) {
        int n = s.length();
        // a = dp[i - 2], b = dp[i - 1], c = dp[i]
        int a = 0, b = 1, c = 0;
        for (int i = 1; i <= n; i++) {
            c = 0; // 注意这里一定要先置 c = 0
            if (s.charAt(i - 1) != '0') {
                c += b;
            }
            if (i > 1 && s.charAt(i - 2) != '0' && (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26) {
                c += a;
            }
            b = c;
            a = b;
        }
        return c;
    }
}
