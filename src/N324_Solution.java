import java.util.Arrays;

/**
 * @author 文进
 * @version 1.0
 * 324.摆动排序II
 */
public class N324_Solution {
    public static void main(String[] args) {
        int[] nums = {2, 1};
        N324_Solution n324_solution = new N324_Solution();
        n324_solution.wiggleSort(nums);
        for (int ele : nums) {
            System.out.println(ele);
        }
    }
    /*
    方法：排序
    如果中间出现重复元素 r , 则要保证 r 在小子数组的头部，在大子数组的尾部，目的是
    要穿插时不会重复，要相互避免。
    时间复杂度：O(nlogn)
    空间复杂度：O(n)
     */
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] aux = new int[nums.length];
        System.arraycopy(nums, 0, aux, 0, nums.length);

        int left = 0, right = n - 1;
        if (n % 2 == 0) {
            left = n / 2 - 1;
        } else {
            left = n / 2;
        }

        for (int i = 0; i < nums.length - 1; i = i + 2) {
            nums[i] = aux[left--];
            nums[i + 1] = aux[right--];
        }
        if (n % 2 != 0) nums[n - 1] = aux[0];
    }
}
