package lcof;

import java.util.*;

/**
 * @author 文进
 * @version 1.0
 * 剑指Offer 03.数组中重复的数字
 */
public class N3_Solution {
    /*
    * 方法一：排序
    * 时间复杂度：O(nlogn)
    * 空间复杂度：O(1)
    */
    public int findRepeatNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) return nums[i];
        }
        return -1;
    }

    /*
       方法：散列表
     */
    public int findRepeatNumber2(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int n : nums) {
            hashMap.put(n, hashMap.getOrDefault(n, 0) + 1);
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            if ((Integer)entry.getValue() > 1) {
                return (Integer) entry.getKey();
            }
        }
        return -1;
    }

    /*
       方法：利用集合
       时间复杂度：O(n)
       空间复杂度：O(n)
     */
    public int findRepeatNumber3(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int repeat = -1;
        for (int n : nums) {
            // 如果集合中添加不进去，就返回
            if (!set.add(n)) {
                repeat = n;
                break;
            }
        }
        return repeat;
    }
}
