import java.util.LinkedList;
import java.util.List;

/**
 * @author 文进
 * @version 1.0
 * 39.组合总和
 */
public class N39_Solution {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    int trackSum = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) {
            return res;
        }
        backtrack(candidates, 0, target);
        return res;
    }

    void backtrack(int[] nums, int start, int target) {
        // base case
        if (trackSum == target) {
            res.add(new LinkedList<>(track));
            return;
        }
        if (trackSum > target) {
            return;
        }

        for (int i = start; i < nums.length; i++) {
            trackSum += nums[i];
            track.add(nums[i]);
            // 同一个元素可以重复使用，因此这里 start = i
            backtrack(nums, i, target);
            trackSum -= nums[i];
            track.removeLast();
        }
    }
}
