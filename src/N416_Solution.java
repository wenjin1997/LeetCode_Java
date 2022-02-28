/**
 * @author 文进
 * @version 1.0
 * 416.分割等和子集
 * 思路：将该问题转换为背包问题
 *      sum(A) + sum(B) = sum(nums)
 *      sum(A) = sum(B)
 *  因此 sum(A) = sum(nums)/2
 *      问题转换为是否可以选择nums中的数，使得总和为sum(nums)/2
 */
public class N416_Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        // 和为奇数时，不可能划分为两个和相等的集合
        if (sum % 2 != 0) return false;
        int n = nums.length;
        sum = sum / 2;
        boolean[][] dp = new boolean[n + 1][sum + 1];
        // base case
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j - nums[i - 1] < 0) {
                    // 背包容量不足，不能装入第 i 个物品
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 装入或不装入背包
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][sum];
    }

    // 对方法1进行空间上的优化，将dp数组压缩为一维的
    public boolean canPartition2(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        // 和为奇数时，不可能分割成两个和相等的子集
        if (sum % 2 != 0) return false;
        int n = nums.length;
        sum = sum / 2;
        boolean[] dp = new boolean[sum + 1];
        // base case
        dp[0] = true;

        // 状态转移
        for (int i = 0; i < n; i++) {
            // j 应该从后往前反向遍历，因为每个物品（或数字）只能用一次，
            //      以免之前的结果影响其他的结果。
            for (int j = sum; j >= 0; j--) {
                if (j - nums[i] >= 0) {
                    dp[j] = dp[j] || dp[j - nums[i]];
                }
            }
        }
        return dp[sum];
    }
}
