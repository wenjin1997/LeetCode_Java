/*
 * @lc app=leetcode.cn id=137 lang=java
 *
 * [137] 只出现一次的数字 II
 */

// @lc code=start
class Solution {
    // 方法一：哈希表
    public int singleNumber1(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    // 方法二：位运算
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int total = 0;
            for (int num : nums) {
                // 计算第 i 位上二进制数之和
                total += (num >> i) & 1;
            }
            // 如果和 3 取余后不为 0，就加到结果的第 i 位上
            if (total % 3 != 0) {
                ans |= (1 << i); 
            }
        }
        return ans;
    }
}
// @lc code=end

