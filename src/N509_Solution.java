/**
 * @author 文进
 * @version 1.0
 * 509.斐波那契数
 */
public class N509_Solution {
}

/*
方法一：暴力解法
时间复杂度：O(2^N)
空间复杂度：O(1)
补充：递归复杂度计算：递归次数*递归内复杂度
 */
class N509_Solution1 {
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib(n - 1) + fib (n - 2);
    }
}

/*
方法二：利用备忘录，自顶向下递归
时间复杂度：O(N)
空间复杂度：O(N)
 */
class N509_Solution2 {
    public int fib(int n) {
        // 备忘录
        int[] memo = new int[n + 1];
        return helper(memo, n);
    }
    int helper(int[] memo, int n) {
        // base case
        if (n == 0) return 0;
        if (n == 1) return 1;
        // 已经计算过，不用再计算，这一步就是降低时间复杂度的关键
        if (memo[n] != 0) return memo[n];
        // 状态转移
        memo[n] = helper(memo, n - 1) + helper(memo, n - 2);
        return memo[n];
    }
}

/*
方法三：dp数组迭代解法，自底向上迭代
时间复杂度：O(N)
空间复杂度：O(N)
 */
class N509_Solution3 {
    public int fib(int n) {
        if (n == 0) return 0;
        int[] dp = new int[n + 1];
        // base case
        dp[0] = 0; dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}

/*
方法四：对迭代法进行空间上的优化
时间复杂度：O(N)
空间复杂度：O(1)
 */
class N509_Solution4 {
    public int fib(int n) {
        if (n == 0 || n == 1) return n;

        int dp_i2 = 0; // dp[i - 2]
        int dp_i1 = 1; // dp[i - 1]
        for (int i = 2; i <= n; i++) {
            // dp[i] = dp[i - 1] + dp[i - 2]
            int dp_i = dp_i1 + dp_i2;
            // 更新
            dp_i2 = dp_i1;
            dp_i1 = dp_i;
        }
        return dp_i1;
    }
}