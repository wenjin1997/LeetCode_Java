/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {
    // 单调栈
    public int trap(int[] height) {
        int ans = 0;
        Deque<Integer> stack = new LinkedList<>();
        int n = height.length;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                // 如果栈中存在至少两个元素，当前的值比较高，那么可以形成一个洼地，可以接雨水
                int left = stack.peek();
                int currWidth = i - left - 1;
                int currHeight = Math.min(height[left] - height[top], height[i] - height[top]);
                ans += currWidth * currHeight;
            }
            stack.push(i);
        }
        return ans;
    }
}
// @lc code=end

