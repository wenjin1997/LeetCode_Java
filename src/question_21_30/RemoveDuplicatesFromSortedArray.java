package question_21_30;

/**
 * @author 文进
 * @version 1.0
 * 26.删除有序数组中的重复项
 * 双指针法
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        // 双指针法
        int leftIndex = 0; // 左指针
        int rightIndex = 1; // 右指针
        while (rightIndex < nums.length) {
            while (nums[leftIndex] == nums[rightIndex] && rightIndex < nums.length - 1) {
                rightIndex++;
            }
            if (nums[leftIndex] != nums[rightIndex]) {
                leftIndex++;
                int temp = nums[leftIndex];
                nums[leftIndex] = nums[rightIndex];
                nums[rightIndex] = temp;
            }
            rightIndex++;
        }
        return leftIndex + 1;
    }
}
