/**
 * @author 文进
 * @version 1.0
 * 70.爬楼梯
 * 思路：动态规划
 *      重点是状态转移，如何状态转移取决于每一次的选择，
 *      这里每次的选择只有两种：爬 1 个台阶 或 爬 2 个台阶。
 *      因此动态转移为 memo[remain] = dp(remain - 2) + dp(remain - 1);
 */
public class N70_Solution {
    public int climbStairs(int n) {
        // 备忘录初始化
        memo = new int[n + 1];
        return dp(n);
    }
    int[] memo; // 备忘录
    int dp(int remain) {
        if (remain <= 0) return 0;
        if (remain == 1 || remain == 2) return remain;

        // 防止重复计算
        if (memo[remain] != 0) {
            return memo[remain];
        }
        // 动态转移
        memo[remain] = dp(remain - 2) + dp(remain - 1);
        return memo[remain];
    }
}
