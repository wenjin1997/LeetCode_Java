import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 文进
 * @version 1.0
 */
public class N15_Solution {
    /*
    方法：排序+双指针
    时间复杂度：O(N^2)
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
       int n = nums.length;
       // 穷举 threeSum 的第一个数
        for (int i = 0; i < n; i++) {
            // 对 target - nums[i] 计算 twoSum
            List<List<Integer>> tuples = twoSumTarget(nums, i + 1, - nums[i]);
            // 如果存在满足条件的二元组，再加上 nums[i] 就是结果的三元组
            for (List<Integer> tuple : tuples) {
                tuple.add(nums[i]);
                res.add(tuple);
            }
            // 跳过第一个数字重复的情况，否则会出现重复结果
            while (i < n - 1 && nums[i] == nums[i + 1]) i++;
        }
        return res;
    }

    List<List<Integer>> twoSumTarget(int[] nums, int start, int target) {
        // 左指针为start
        int lo = start, hi = nums.length - 1;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            int left = nums[lo], right = nums[hi];
            if (sum < target) {
                while (lo < hi && nums[lo] == left) lo++;
            } else if (sum > target) {
                while (lo < hi && nums[hi] == right) hi--;
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(nums[lo]);
                list.add(nums[hi]);
                res.add(list);
                while (lo < hi && nums[lo] == left) lo++;
                while (lo < hi && nums[hi] == right) hi--;
            }
        }
        return res;
    }
}
