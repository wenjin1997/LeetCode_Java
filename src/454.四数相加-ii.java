/*
 * @lc app=leetcode.cn id=454 lang=java
 *
 * [454] 四数相加 II
 */

// @lc code=start
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // 思路：分组 + hashMap
        Map<Integer, Integer> map = new HashMap<>();
        for (int u : nums1) {
            for (int v : nums2) {
                map.put(u + v, map.getOrDefault(u + v, 0) + 1);
            }
        }
        int res = 0;
        for (int u : nums3) {
            for (int v : nums4) {
                if (map.containsKey(- u - v)) {
                    res += map.get(- u - v);
                }   
            }
        }
        return res;
    }
}
// @lc code=end

