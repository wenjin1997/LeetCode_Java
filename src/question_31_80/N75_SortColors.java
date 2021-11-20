package question_31_80;

/**
 * @author 文进
 * @version 1.0
 * 75. 颜色分类
 */
public class N75_SortColors {
    public static void main(String[] args) {
        Solution s = new Solution();
//        int[] nums = {2, 0 , 2, 1, 1, 0};
        int[] nums = {2, 0 , 1};
        s.sortColors(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}

class Solution {
    public void sortColors(int[] nums) {
        int N = nums.length;
        if (N == 1) return;
        int lt = 0, i = 0, gt = N - 1;
        while(i <= gt) {
            if (nums[i] < 1) exch(nums, lt++, i++);
            else if (nums[i] > 1) exch(nums, i, gt--);
            else i++;
        }
    }

    public void exch(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
