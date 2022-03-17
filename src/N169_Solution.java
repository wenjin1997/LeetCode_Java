import java.util.Arrays;
import java.util.HashMap;

/**
 * @author 文进
 * @version 1.0
 * 169.多数元素
 */
public class N169_Solution {
    /*
    方法一：哈希表
    时间复杂度：O(n)
    空间复杂度：O(n)
     */
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxKey = nums[0];
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(maxKey) < map.get(nums[i])) {
                maxKey = nums[i];
            }
        }
        return maxKey;
    }
    /*
    方法二：排序
           排序后下标为[n/2]一定是众数
    时间复杂度：O(n logn)
    空间复杂度：O(logn)
     */
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /*
    方法三：Boyer-Moore投票法
    思路：计票制，由于题中有条件多数元素的个数多余[n/2]，可以比作两两抵消，剩下的多数元素的
         票数一定大于1。
    时间复杂度：O(n)
    空间复杂度：O(1)
     */
    public int majorityElement3(int[] nums) {
        int candidate = nums[0]; // 初始候选人
        int count = 1;           // 票数
        for (int i = 1; i < nums.length; i++) {
            if (candidate == nums[i]) { // 如果当前值为候选人的值，票数增加
                count++;
            } else { // 当前的值不是候选人
                if (count > 0){ // 如果票数还有，就减票数
                    count--;
                } else { // 如果票数没了，就要更换候选人并重置票数
                    candidate = nums[i]; // 更换候选人
                    count = 1;           // 票数重置为1
                }
            }
        }
        return candidate;
    }

}
