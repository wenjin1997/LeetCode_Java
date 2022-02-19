import java.util.Arrays;

/**
 * @author 文进
 * @version 1.0
 * 322.零钱兑换
 */
public class N322_Solution {
}

/*
方法一：暴力递归
时间复杂度：O(k*n^k)
          k是coins的个数，n是amount的数
1.确定base case：amount为0时，返回0
2.状态：amount的变化
3.选择：所有硬币的面值，就是选择
4.明确dp函数/数组的定义
 */
class N322_Solution1 {
    public int coinChange(int[] coins, int amount) {
        return dp(coins, amount);
    }
    int dp(int[] coins, int amount) {
        // base case
        if (amount == 0) return 0;
        if (amount < 0) return -1;

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            // 计算子问题的结果
            int subProblem = dp(coins, amount - coin);
            // 子问题无解则跳过
            if (subProblem == -1) continue;
            // 在子问题中选择最优解，然后加一
            res = Math.min(res, subProblem + 1);
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}

/*
方法二：带备忘录的递归
时间复杂度：O(kn)
 */
class N322_Solution2 {
    int[] memo;
    public int coinChange(int[] coins, int amount) {
        memo = new int[amount + 1];
        // dp数全部初始化为特殊值-666，这里-666可以改为任意不为-1的负数
        Arrays.fill(memo, -666);

        return dp(coins, amount);
    }
    int dp(int[] coins, int amount) {
        // base case
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        // 查备忘录，防止重复计算
        if (memo[amount] != -666) {
            return memo[amount];
        }

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            // 计算子问题的解
            int subProblem = dp(coins, amount - coin);
            // 子问题无解则跳过
            if (subProblem == -1) continue;
            // 在子问题中选择最优解，然后加一
            res = Math.min(res, subProblem + 1);
        }
        // 把计算结果存入备忘录
        memo[amount] = (res == Integer.MAX_VALUE) ? -1 : res;
        return memo[amount];
    }
}

/*
方法三：dp数组的迭代解法
 */
class N322_Solution3 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // 数组初始值为amount + 1
        Arrays.fill(dp, amount + 1);

        // base case
        dp[0] = 0;
        // 外层for循环在遍历所有状态的所有取值
        for (int i = 0; i < dp.length; i++) {
            // 内层for循环在求所有选择的最小值
            for (int coin : coins) {
                // 子问题无解，跳过
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }
}