import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        return nSum(nums, 4, 0, target);
    }

    // n 数之和
    public List<List<Integer>> nSum(int[] nums, int n, int start, int target) {
        // 先对数组排序
        Arrays.sort(nums);

        List<List<Integer>> res = new LinkedList<>();
        // 至少是两数之和，且数组大小不应该小于 n
        if (n < 2 || nums.length < n) return res;
        // 如果是两数之和，就用双指针的方法
        if (n == 2) {
            int left = start, right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                int leftNum = nums[left], rightNum = nums[right];
                if (sum < target) {
                    while (left < right && nums[left] == leftNum) left++;
                } else if (sum > target) {
                    while (left < right && nums[right] == rightNum) right--;
                } else {
                    List<Integer> list = new LinkedList<>();
                    list.add(leftNum);
                    list.add(rightNum);
                    res.add(list);
                    while (left < right && nums[left] == leftNum) left++;
                    while (left < right && nums[right] == rightNum) right--;
                }
            }
        } else {
            for (int i = start; i < nums.length; i++) {
                List<List<Integer>> lists = nSum(nums, n - 1, i + 1, target - nums[i]);
                for (List<Integer> list : lists) {
                    list.add(nums[i]);
                    res.add(list);
                }
                while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
            }
        }
        return res;
    }
}
// @lc code=end

