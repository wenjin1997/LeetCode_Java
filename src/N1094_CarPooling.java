/**
 * @author 文进
 * @version 1.0
 * 1094.拼车
 * 思路：差分数组解决
 */
public class N1094_CarPooling {
}

class N1094_Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        // 用差分数组解决

        // 最多有1001个车站
        int[] nums = new int[1001];
        Difference df = new Difference(nums);

        for (int[] trip : trips) {
            // 乘客数量
            int val = trip[0];
            // 第 trip[1]站乘客上车
            int i = trip[1];
            // 第trip[2]站乘客下车
            // 乘客在车上的区间是 [trip[1], trip[2] - 1]
            int j = trip[2] - 1;
            df.increment(i, j, val);
        }

        int[] res = df.result();

        // 客车从始至终不应该超载
        for (int i = 0; i < res.length; i++) {
            if (res[i] > capacity) {
                return false;
            }
        }
        return true;
    }

    /* 差分数组类 */
    class Difference {
        private int[] diff;

        public Difference(int[] nums) {
            diff = new int[nums.length];
            diff[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                diff[i] = nums[i] - nums[i - 1];
            }
        }

        public void increment(int i, int j, int val) {
            diff[i] += val;
            if (j + 1 < diff.length) {
                diff[j + 1] -= val;
            }
        }

        public int[] result() {
            int[] ans = new int[diff.length];
            ans[0] = diff[0];
            for (int i = 1; i < ans.length; i++) {
                ans[i] = ans[i - 1] + diff[i];
            }
            return ans;
        }
    }
}


