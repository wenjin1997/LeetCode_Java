/**
 * @author 文进
 * @version 1.0
 * 303.区域和检索——数组不可变、
 * 思路方法：前缀和数组
 */
public class N303_RangeSumQuery_Immutable {

}

class NumArray {
    private int[] preSum; // 前缀和数组

    public NumArray(int[] nums) {
        preSum = new int[nums.length + 1];
        preSum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return preSum[right + 1] - preSum[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
