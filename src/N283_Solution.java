/**
 * @author 文进
 * @version 1.0
 * 283.移动零
 * 方法：快慢指针法
 */
public class N283_Solution {
    public void moveZeroes(int[] nums) {
        // 双指针法
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                //  nums[0,...,slow - 1]是非0元素
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        for (int i = slow; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
