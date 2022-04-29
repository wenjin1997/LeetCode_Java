/*
 * @lc app=leetcode.cn id=260 lang=java
 *
 * [260] 只出现一次的数字 III
 */

// @lc code=start
class Solution {
    // 方法一：哈希表
    public int[] singleNumber1(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        int[] res = new int[2];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            // 找到只出现一次的元素
            if (entry.getValue() == 1) {
                res[index++] = entry.getKey();
            }
        }
        return res;
    }

    // 方法二：位运算
    public int[] singleNumber(int[] nums) {
        int xorsum = 0;
        for (int num : nums) {
            xorsum ^= num;
        }

        // xorsum & (-xorsum) 可以取到 xorsum 的最低位那个 1
        // 如果 xorsum 溢出，就是 xorsum 1000 0000 0000 0000 0000 0000 0000 0000
        int l = (xorsum == Integer.MIN_VALUE? xorsum : xorsum & (-xorsum));
        int r1 = 0, r2 = 0;
        for (int num : nums) {
            // 将 nums 分成两类，一类第 l 位为1，一类第 l 位为 0
            if ((num & l) != 0) { // 如果 num 的第 l 位为1
                r1 ^= num;
            } else {
                r2 ^= num;
            }
        }
        return new int[]{r1, r2};
    }
}
// @lc code=end

