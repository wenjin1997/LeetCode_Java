/*
 * @lc app=leetcode.cn id=560 lang=java
 *
 * [560] 和为 K 的子数组
 */

// @lc code=start
class Solution {
    public int subarraySum(int[] nums, int k) {
        // 前缀和 -> 前缀和出现的次数
        HashMap<Integer, Integer> map = new HashMap<>();
        // 先将(0, 1)放入
        map.put(0, 1);

        int res = 0, sum0_i = 0;
        for (int i = 0; i < nums.length; i++) {
            sum0_i += nums[i];
            int sum0_j = sum0_i - k;
            if (map.containsKey(sum0_j)) {
                res += map.get(sum0_j);
            }
            map.put(sum0_i, map.getOrDefault(sum0_i, 0) + 1);
        }
        return res;
    }
}
// @lc code=end

