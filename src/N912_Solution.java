import java.util.Arrays;

/**
 * @author 文进
 * @version 1.0
 * 912.排序数组
 */
// 方法一：快速排序
public class N912_Solution {
    public int[] sortArray(int[] nums) {
        return sortArray(nums, 0, nums.length - 1);
    }

    private int[] sortArray(int[] nums, int lo, int hi) {
        if (hi <= lo) return nums;
        int j = partition(nums, lo, hi);
        sortArray(nums, lo, j);
        sortArray(nums, j + 1, hi);
        return nums;
    }

    private int partition(int[] nums, int lo, int hi) {
        int i = lo, j = hi + 1;
        int v = nums[lo];
        while (true) {
            while (nums[++i] <= v) {
                if (i == hi) break;
            }
            while (v <= nums[--j]) {
                if (j == lo) break;
            }

            if (i >= j) break;
            exch(nums, i, j);
        }
        exch(nums, lo, j);
        return j;
    }

    private void exch(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

/*
方法二：归并排序
 */
class N912_Solution2{
    public int[] sortArray(int[] nums) {
        return sortArray(nums, 0, nums.length - 1);
    }

    private int[] sortArray(int[] nums, int lo, int hi) {
        if (lo >= hi) return nums;
        int mid = lo + (hi - lo) / 2;
        sortArray(nums, lo, mid);
        sortArray(nums, mid + 1, hi);
        return merge(nums, lo, mid, hi);
    }

    // 归并两个数组
    private int[] merge(int[] nums, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        int[] aux = new int[nums.length];
//        if (hi + 1 - lo >= 0) System.arraycopy(nums, lo, aux, lo, hi + 1 - lo);
        for (int k = lo; k <= hi; k++) {
            aux[k] = nums[k];
        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid)                nums[k] = aux[j++];
            else if (j > hi)            nums[k] = aux[i++];
            else if (aux[j] < aux[i])   nums[k] = aux[j++];
            else                        nums[k] = aux[i++];
        }
        return nums;
    }
}
