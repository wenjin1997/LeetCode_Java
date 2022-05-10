/*
 * @lc app=leetcode.cn id=287 lang=java
 *
 * [287] 寻找重复数
 */

// @lc code=start
class Solution {
    // 二分查找
    // 将 1 ～ n 分为两部分
    // 参考剑指Offer P42
    public int findDuplicate(int[] nums) {
        int start = 1, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int count = countRange(nums, start, mid);
            if (start == end) {
                if (count > 1) {
                    return start;
                } else {
                    break;
                }
            }
            if (count > (mid - start + 1)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    // 返回数组中元素大小在 [start, end] 之间出现的次数
    private int countRange(int[] nums, int start, int end) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= start && nums[i] <= end) {
                count++;
            }
        }
        return count;
    }
}
// @lc code=end

