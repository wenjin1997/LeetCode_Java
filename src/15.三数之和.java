/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // 先固定第一个数，再在剩下的数组中找到两数之和等于 -nums[i]的
        // 首先对数组进行排序
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        // 固定第一个数
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> tuples = twoSum(nums, i + 1, - nums[i]);
            for (List<Integer> tuple : tuples) {
                tuple.add(nums[i]);
                res.add(tuple);
            }
            // 防止第一个元素重复
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
        }
        return res;
    }

    /*
    两数之和
    思路：先对数组排序，再用双指针方法求解，注意要防止结果重复
    */
    private List<List<Integer>> twoSum(int[] nums, int start, int target) {
        List<List<Integer>> res = new LinkedList<>();
        int left = start, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            int leftNum = nums[left], rightNum = nums[right];
            if (sum < target) { // 当前的和比较小，那么要增大增加的元素
                while (nums[left] == leftNum && left < right) left++;
            } else if (sum > target) {
                while (nums[right] == rightNum && left < right) right--;
            } else {
                List<Integer> temp = new LinkedList<>();
                temp.add(leftNum);
                temp.add(rightNum);
                res.add(temp);
                while (nums[left] == leftNum && left < right) left++;
                while (nums[right] == rightNum && left < right) right--;
            }
        }
        return res;
    }

}
// @lc code=end