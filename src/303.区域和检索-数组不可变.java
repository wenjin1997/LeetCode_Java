/*
 * @lc app=leetcode.cn id=303 lang=java
 *
 * [303] 区域和检索 - 数组不可变
 */

// @lc code=start
class NumArray {
    // 前缀和数组
    int[] preSums;

    public NumArray(int[] nums) {
        int n = nums.length;
        // 初始化前缀和数组
        preSums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preSums[i] = preSums[i - 1] + nums[i - 1];
        }

    }
    
    public int sumRange(int left, int right) {
        // nums[left] + nums[left + 1] + ... + nums[right]
        // = preSums[right + 1] - preSums[left]
        return preSums[right + 1] - preSums[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
// @lc code=end

