import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 文进
 * @version 1.0
 * 47.全排列II
 */
public class N47_Solution {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used);
        return res;
    }

    void backtrack(int[] nums, boolean[] used) {
        // base case
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            // 注意这里剪枝逻辑，一定要添加 !used[i - 1]，否则结果为[]
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            track.add(nums[i]);
            used[i] = true;
            backtrack(nums, used);
            track.removeLast();
            used[i] = false;
        }
    }
}
