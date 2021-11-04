package question_21_30;

/**
 * @author 文进
 * @version 1.0
 * 27.移除元素
 * 方法：双指针法
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        RemoveElement r = new RemoveElement();
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 3;
        System.out.println(r.removeElement(nums, val));
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}

