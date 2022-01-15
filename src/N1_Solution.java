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
