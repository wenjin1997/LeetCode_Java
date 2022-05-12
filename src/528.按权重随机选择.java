/*
 * @lc app=leetcode.cn id=528 lang=java
 *
 * [528] 按权重随机选择
 */

// @lc code=start
class Solution {
    // 前缀和数组
    private int[] preSum;
    private Random rand = new Random();

    public Solution(int[] w) {
        preSum = new int[w.length + 1];
        // 初始化前缀和数组
        for (int i = 1; i < w.length + 1; i++) {
            preSum[i] = preSum[i - 1] + w[i - 1];
        }
    }
    
    public int pickIndex() {
        int n = preSum.length;
        // 生成 [1, preSem[n - 1]] 的随机数
        int target = rand.nextInt(preSum[n - 1]) + 1;
        return leftBound(preSum, target) - 1;
    }

    // 找 >= target 的左侧边界
    private int leftBound(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return left;
    }

}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
// @lc code=end

