/*
 * @lc app=leetcode.cn id=167 lang=java
 *
 * [167] 两数之和 II - 输入有序数组
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // 双指针法
        int left = 0, right = numbers.length - 1;
        int[] ans = new int[2];
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (target == sum) {
                ans[0] = left + 1;
                ans[1] = right + 1;
                break;
            } else if (target < sum) {
                right--;
            } else if (target > sum) {
                left++;
            }
        }
        return ans;
    }
}
// @lc code=end

