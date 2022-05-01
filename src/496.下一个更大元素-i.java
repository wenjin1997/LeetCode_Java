/*
 * @lc app=leetcode.cn id=496 lang=java
 *
 * [496] 下一个更大元素 I
 */

// @lc code=start
class Solution {
    // 单调栈 + 哈希表
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>(); // 方便返回答案
        // Deque 是双端队列
        Deque<Integer> stack = new ArrayDeque<>();
        // 逆序遍历数组
        for (int i = nums2.length - 1; i >= 0; i--) {
            // 如果栈不为空，并且当前的值比栈顶元素大，则抛出栈顶元素，因为不可能是下一个更大元素
            // 直到栈为空或者找到下一个更大的元素
            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                stack.pop();
            }
            // 存储当前数的下一个最大元素，数组中没有重复元素，因此可以使用HashMap
            map.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
            // 向栈中添加当前元素
            stack.push(nums2[i]);
        }
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }
}
// @lc code=end

