/**
 * @author 文进
 * @version 1.0
 * 34.在排序数组中查找元素的第一和最后一个位置
 * 思路：二分查找
 */
public class N34_Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{left_bound(nums, target), right_bound(nums, target)};
    }

    // 找到左边界的代码
    public int left_bound(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1; // 注意

        while (left <= right) { // 注意
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                // 搜索区间为[left, mid - 1]
                right = mid - 1;
            } else if (nums[mid] < target) {
                // 搜索区间为[mid + 1, right]
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 搜索区间为[left, mid - 1]
                right = mid - 1; // 注意
            }
        }
        // target 比所有数都大
        if (left >= nums.length) return -1;
        return nums[left] == target ? left : -1;
     }

     // 找到右边界的代码
    public int right_bound(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                // 搜索区间为[left, mid - 1]
                left = mid + 1;
            } else if (nums[mid] < target) {
                // 搜索区间为[mid + 1, right]
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 搜索区间为[left, mid - 1]
                right = mid - 1;
            }
        }
        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }

}
