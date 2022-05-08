package lcof;

import java.util.*;

/**
 * @author 文进
 * @version 1.0
 * 剑指Offer 03.数组中重复的数字
 */
public class N3_Solution {
    /*
       方法：原地交换
       时间复杂度：O(n)
       空间复杂度：O(1)
     */
    public int findRepeatNumber(int[] nums) {
        int i = 0;
        while(i < nums.length) {
            // 找到下标和元素不相等的指标
            while (i < nums.length && nums[i] == i) i++;
            // 下标和元素不相等
            if (nums[i] == nums[nums[i]]) {
                return nums[i];
            } else {
                // 交换
                int temp = nums[i];
                nums[i] = nums[nums[i]];
                nums[temp] = temp;
            }
        }
        return -1;
    }

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
