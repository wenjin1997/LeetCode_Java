/*
 * @lc app=leetcode.cn id=209 lang=java
 *
 * [209] 长度最小的子数组
 */

// @lc code=start
class Solution {
    // 前缀和数组 + 滑动窗口
    public int minSubArrayLen(int target, int[] nums) {
        int[] preSum = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            preSum[i] = sum;
        }
        int left = 0, right = 0;
        int length = Integer.MAX_VALUE;
        while (left <= right && right < nums.length) {
            while (right < nums.length && preSum[right] - preSum[left] + nums[left] < target) {
                right++;
            }
            System.out.println(right);
            length = Math.min(length, right - left + 1);
            System.out.println(length);
            left++;
        }
        return preSum[nums.length - 1] < target ? 0 : length;
    }
}
// @lc code=end

