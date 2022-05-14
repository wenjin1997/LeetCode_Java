/*
 * @lc app=leetcode.cn id=1011 lang=java
 *
 * [1011] 在 D 天内送达包裹的能力
 */

// @lc code=start
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = Integer.MIN_VALUE; // 初始值应该为数组中的最小值
        int right = 0; // 初始化为整个数组的和
        for (int weight : weights) {
            right += weight;
            left = Math.max(left, weight);
        }
        // 左侧边界的二分搜索
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midNeedDays = needDay(weights, mid);
            // System.out.println(mid + "-" + midNeedDays);
            // System.out.println("left: " + left + " right: " + right);
            if (midNeedDays == days) {
                right = mid - 1;
            } else if (midNeedDays > days) { // 所需时间增加，说明当前载重太小了
                left = mid + 1;
            } else if (midNeedDays < days) {
                right = mid - 1;
            }
        }
        return left;
    }

    // 返回船舶载量为 loadWeight 时运输所有包裹所需的时间
    private int needDay(int[] weights, int loadWeight) {
        int day = 0;
        int sum = 0;
        int i = 0;
        while (i < weights.length) {
            while (i < weights.length && ((sum += weights[i]) <= loadWeight)) {
                i++;
            }
            day++;
            sum = 0;
        }
        return day;
    }
}
// @lc code=end

