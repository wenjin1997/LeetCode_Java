/*
 * @lc app=leetcode.cn id=1109 lang=java
 *
 * [1109] 航班预订统计
 */

// @lc code=start
class Solution {
    // 用差分数组解决
    // 差分数组：适合频繁修改数组的情况
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] differ = new int[n];
        for (int[] booking : bookings) {
            // 注意这里下标要减一
            int i = booking[0] - 1, j = booking[1] - 1, num = booking[2];
            differ[i] += num;
            if (j + 1 < n) differ[j + 1] -= num;
        }
        // 还原数组
        int[] answer = new int[n];
        answer[0] = differ[0];
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] + differ[i];
        }
        return answer;
    }
}
// @lc code=end

