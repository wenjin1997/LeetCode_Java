import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author 文进
 * @version 1.0
 * 217.存在重复元素
 */
public class N217_Solution {
    /*
    方法一：先给数组排序，然后比较相邻的元素，如果相同就返回true。
    时间复杂度:O(NlogN)，来自于对数组排序
    空间复杂度:O(logN)，递归调用栈的深度
     */
    public boolean containsDuplicate(int[] nums) {
        if (nums.length == 1) return false;
        // 先给数组排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == nums[i + 1]) return true;
        }
        return false;
    }

    /*
    方法二：利用Set，因为Set不允许存在重复元素，如果添加不进去，返回false。
    时间复杂度：O(N)
    空间复杂度：O(N)
     */
    public boolean containsDuplicate2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            if (!set.add(x)) { // 如果添加不进去，就返回false
                return true;
            }
        }
        return false;
    }
}
