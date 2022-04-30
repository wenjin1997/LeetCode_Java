/*
 * @lc app=leetcode.cn id=75 lang=java
 *
 * [75] 颜色分类
 */

// @lc code=start
class Solution {
    // 三向切分方法
    public void sortColors(int[] nums) {
        if (nums.length <= 1) return;
        int i = 0, lt = 0, gt = nums.length - 1;
        while (i <= gt) {
            if (nums[i] < 1) {
                nums[i++] = nums[lt];
                nums[lt++] = 0;
            } else if (nums[i] > 1) {
                nums[i] = nums[gt];
                nums[gt--] = 2;
            } else {
                i++;
            }
        }
    }
}
// @lc code=end

