/**
 * @author 文进
 * @version 1.0
 * 88.合并两个有序数组
 */
public class N88_Solution {
    /*
    方法：原地归并方法，参考《算法》P170原地归并的抽象方法
    时间复杂度：O(m + n)
    空间复杂度：O(m + n)
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0;
        int[] sorted = new int[m + n];
        for (int k = 0; k < m + n; k++) {
            if (i >= m) sorted[k] = nums2[j++];
            else if (j >= n) sorted[k] = nums1[i++];
            else if (nums1[i] <= nums2[j]) sorted[k] = nums1[i++];
            else if (nums1[i] > nums2[j]) sorted[k] = nums2[j++];
        }
        // 将排好序的数组与元素复制到 nums1 数组中
        //        for(int k = 0; k < m + n; k++) {
        //            nums1[k] = sorted[k];
        //        }
        if (m + n >= 0) System.arraycopy(sorted, 0, nums1, 0, m + n);
    }

    /*
    方法：逆向双指针，因为想要节省空间，在nums1数组上进行原地排序，就需要利用nums1[m,...,m+n-1]
        的空间
    时间复杂度：O(m + n)
    空间复杂度：O(1)
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int tail = m + n - 1; // 末尾指针，方便修改数组，装入较大的那个值
        int i = m - 1, j = n - 1;
        int cur = 0; // 记录当前应该装入的值
        while (i >= 0 || j >= 0) {
            if (i == -1) cur = nums2[j--];
            else if (j == -1) cur = nums1[i--];
            else if (nums1[i] >= nums2[j]) cur = nums1[i--];
            else if (nums1[i] < nums2[j]) cur = nums2[j--];
            nums1[tail--] = cur;
        }
    }
}
