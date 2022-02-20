import java.util.Arrays;

/**
 * @author 文进
 * @version 1.0
 * 300.最长递增子序列
 */
public class N300_Solution {
}

/*
方法一：动态规划解法
时间复杂度：O(N^2)
动态规划的设计方法：假设之前的答案已知，利用数学归纳的思想正确进行状态的推演转移，
                最终得到答案。
 */
class N300_Solution1 {
    public int lengthOfLIS(int[] nums) {
        // 定义：dp[i]表示以nums[i]这个数结尾的最长递增子序列的长度
        int[] dp = new int[nums.length];
        // base case: dp数组全部初始化为1
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // dp数组中的最大数就是要求的结果
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}

/*
方法二：二分查找解法
时间复杂度：O(NlogN)
该方法了解即可
 */
class N300_Solution2 {
    public int lengthOfLIS(int[] nums) {
        int[] top = new int[nums.length];
        // 牌堆数初始化为0
        int piles = 0;
        for (int i = 0; i < nums.length; i++) {
            // 要处理的扑克牌
            int poker = nums[i];

            /****** 搜索左侧边界的二分查找 ******/
            int left = 0, right = piles;
            while (left < right) {
                int mid = (left + right) / 2;
                if (top[mid] > poker) {
                    right = mid;
                } else if (top[mid] < poker) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            /********************************/

            // 没有找到合适的牌堆，新建一堆
            if (left == piles) piles++;
            // 把这张牌放到牌堆顶
            top[left] = poker;
        }
        // 牌堆数就是 LTS 长度
        return piles;
    }
}