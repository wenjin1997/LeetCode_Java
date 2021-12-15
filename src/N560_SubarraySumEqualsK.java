import java.util.HashMap;

/**
 * @author 文进
 * @version 1.0
 * 560.和为K的子数组
 * 思路：前缀和 + 哈希表 解决
 *      哈希表在记录前缀和的同时记录前缀和出现的次数
 *      可以避免内层循环
 */
public class N560_SubarraySumEqualsK {
}

class N560_Solution {
    public int subarraySum(int[] nums, int k) {
        // 前缀和 + HashMap 解决
        int n = nums.length;
        HashMap<Integer, Integer> preSum = new HashMap<>();
        // 基本情况
        preSum.put(0, 1);

        int sum0_i = 0, res = 0;  // sum0_i表示前i个数的和，res用来记录结果
        for (int i = 0; i < n; i++) {
            sum0_i += nums[i];
            int sum0_j = sum0_i - k;
            if (preSum.containsKey(sum0_j)) { // 如果前面已经出现，则直接更新到结果中
                res += preSum.get(sum0_j);
            }
            preSum.put(sum0_i, preSum.getOrDefault(sum0_i, 0) + 1);
        }
        return res;
    }
}
