package question_501_1000;

/**
 * @author 文进
 * @version 1.0
 * 704.二分查找
 */
public class N704_BinarySearch {
}

class Solution {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < target) lo = mid + 1;
            else if (nums[mid] > target) hi = mid - 1;
            else return mid;
        }
        return -1;
    }
}
