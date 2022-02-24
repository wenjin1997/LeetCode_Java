/**
 * @author 文进
 * @version 1.0
 * 53.最大数组和
 * 思路：动态规划，重要的是dp数组的定义
 *      dp[i]表示以nums[i]为结尾的数组的最大子数组和，
 *      这样定义可以进行动态转移，nums[i]可以选择加入
 *      到最大子数组和中（如果和前面数组相邻的话）或者
 *      自成一派（和前面数组不相邻或者和更大）
 *      对于上述动态规划方法，由于每次dp[i]只依赖dp[i-1]
 *      的结果，因此可以进行空间上的优化
 */
public class N53_Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[] dp = new int[n];
        // base case
        // 第一个元素前面没有子数组
        dp[0] = nums[0];
        // 状态转移方程
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
        }
        // 得到 nums 的最大子数组
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    int maxSubArray2(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        // base case
        int dp_0 = nums[0];
        int dp_1 = 0, res = dp_0;

        for (int i = 1; i < n; i++) {
            // dp[i] = max(nums[i], nums[i] + dp[i - 1]
            dp_1 = Math.max(nums[i], nums[i] + dp_0);
            dp_0 = dp_1;
            // 顺便计算最大的结果
            res = Math.max(res, dp_1);
        }

        return res;
    }
}
