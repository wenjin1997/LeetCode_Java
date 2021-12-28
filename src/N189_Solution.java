/**
 * @author 文进
 * @version 1.0
 * 189.轮转数组
 */
public class N189_Solution {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 9;
        N189_Solution solution = new N189_Solution();
        solution.rotate(nums, k);
        for (int num : nums) {
            System.out.println(num);
        }
    }
    public void rotate(int[] nums, int k) {
        k %= nums.length; // 防止k比nums.length大的情况
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}
