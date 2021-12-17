import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author 文进
 * @version 1.0
 * 350.两个数组的交集II
 * 方法一：哈希表
 */
public class N350_IntersectionOfTwoArraysII {
}

class N350_Solution1 {
    public int[] intersect(int[] nums1, int[] nums2) {
        // 用哈希表解决
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> table = new HashMap<>();
        // 先遍历第一个数组，放入哈希表中，记录第一个数组中各个数出现的频次
        for (int i = 0; i < nums1.length; i++) {
            table.put(nums1[i], table.getOrDefault(nums1[i], 0) + 1);
        }
//        // 或者用增强for循环
//        for (int num : nums1) {
//            table.put(num, table.getOrDefault(num, 0) + 1);
//        }

        // 再遍历第二个数组，如果在第二个数组中出现了第一个数组中的数，就放入结果中，并将次数减一
        for (int i = 0; i < nums2.length; i++) {
            if (table.get(nums2[i]) != null && table.get(nums2[i]) > 0) {
                res.add(nums2[i]);
                table.put(nums2[i], table.get(nums2[i]) - 1);
            }
        }

        // 将结果ArrayList转换为int数组
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
