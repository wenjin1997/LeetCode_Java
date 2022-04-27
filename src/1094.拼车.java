/*
 * @lc app=leetcode.cn id=1094 lang=java
 *
 * [1094] 拼车
 */

// @lc code=start
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        // 差分数组
        //数组的长度根据 0 <= fromi < toi <= 1000 得到
        int[] differ = new int[10001];
        for (int[] trip : trips) {
            int val = trip[0];
            int from = trip[1], to = trip[2];
            differ[from] += val;
            if (to + 1 < 10001) {
                differ[to] -= val;
            } 
        }

        // 恢复载客人数的数组
        int[] nums = new int[10001];
        nums[0] = differ[0];
        // 不要忘记检查第一个元素的 capacity
        if (nums[0] > capacity) return false;

        for (int i = 1; i < 10001; i++) {
            nums[i] = differ[i] + nums[i - 1];
            if (nums[i] > capacity) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

