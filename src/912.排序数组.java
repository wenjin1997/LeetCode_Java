/*
 * @lc app=leetcode.cn id=912 lang=java
 *
 * [912] 排序数组
 */

// @lc code=start
class Solution {
    // 快速排序
    public int[] sortArray(int[] nums) {
        sortArray(nums, 0, nums.length - 1);
        return nums;
    }
    private void sortArray(int[] nums, int lo, int hi) {
        if (lo >= hi) return;
        int j = partition(nums, lo, hi);
        sortArray(nums, lo, j - 1);
        sortArray(nums, j + 1, hi);
    }
    // 切分算法
    private int partition(int[] nums, int lo, int hi) {
        int v = nums[lo]; // 切分元素
        int i = lo, j = hi + 1;
        while (true) {
            while (nums[++i] <= v) if(i == hi) break;
            while (nums[--j] >= v) if(j == lo) break;
            if (i >= j) break;
            // 交换 nums[i] 与 nums[j]
            exch(nums, i, j);
        }
        exch(nums, lo, j);
        return j;

    }
    private void exch(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// @lc code=end

