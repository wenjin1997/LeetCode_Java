/*
 * @lc app=leetcode.cn id=875 lang=java
 *
 * [875] 爱吃香蕉的珂珂
 */

// @lc code=start
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1; // 珂珂吃香蕉的最小速度为 1
        int right = 1; // 珂珂吃香蕉的最大速度，取数组中的最大值
        for (int i = 0; i < piles.length; i++) {
            right = Math.max(right, piles[i]);
        } 
        // System.out.println(right);
        // 左侧边界的二分搜索
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midSpendTime = spendTime(piles, mid); // 珂珂以 mid 速度吃香蕉所花费的时间
            // System.out.println(midSpendTime);
            if (midSpendTime == h) {
                right = mid - 1;
            } else if (midSpendTime > h) {
                left = mid + 1;
            } else if (midSpendTime < h) {
                right = mid - 1;
            }
        }

        return left;
    }

    // 使用速度 k 吃香蕉所需花费的时间
    private int spendTime(int[] piles, int k) {
        int time = 0;
        for (int i = 0; i < piles.length; i++) {
            // 如果能够除尽
            if (piles[i] % k == 0) {
                time += piles[i] / k;
            } else { // 不能除尽就需要 + 1
                time += piles[i] / k + 1;
            }
        }
        return time;
    }
}
// @lc code=end

