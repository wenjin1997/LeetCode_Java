/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除有序数组中的重复项
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int slow = 0, fast = 0;
        while (fast < n) {
            if (nums[fast] != nums[slow]) {
                slow++;
                // 维护 nums[0,...,slow] 无重复项
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }
}
// @lc code=end

