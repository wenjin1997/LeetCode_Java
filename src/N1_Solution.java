import java.util.HashMap;

/**
 * @author 文进
 * @version 1.0
 * 1. 两数之和
 */
public class N1_Solution {
}
/** 暴力解法 **/
class N1_Solution1 {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        // 未找到
        return new int[] {-1, -1};
    }
}

/** 哈希表 **/
class N1_Solution2 {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, Integer> index = new HashMap<>();
        // 构造一个哈希表：元素映射到相应的索引
        for (int i = 0; i < n; i++)
            index.put(nums[i], i);

        for (int i = 0; i < n; i++) {
            int other = target - nums[i];
            // 如果 other 存在且不是 nums[i] 本身
            if (index.containsKey(other) && index.get(other) != i)
                return new int[] {i, index.get(other)};
        }

        return new int[] {-1, -1};
    }
}
