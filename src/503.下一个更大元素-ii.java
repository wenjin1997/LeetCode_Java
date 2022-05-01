/*
 * @lc app=leetcode.cn id=503 lang=java
 *
 * [503] 下一个更大元素 II
 */

// @lc code=start
class Solution {
    // 单调栈 + 循环数组
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Deque<Integer> stack = new LinkedList<>();
        // 用指标取模来模拟有 2 * n 长度的数组[0, ... , n - 1, 0, ... , n - 1]
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i % n] >= stack.peek()) {
                stack.pop();
            }
            res[i % n] = (stack.isEmpty() ? -1 : stack.peek());
            stack.push(nums[i % n]);
        }
        return res;
    }
}
// @lc code=end

