/**
 * @author 文进
 * @version 1.0
 * 1109.航班预定统计
 * 思路：用差分数组解决
 */
public class N1109_CorporateFlightBookings {
}


class N1109_Solution1 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        /* 用差分数组方法 这里用了差分数组类 */
        int[] nums = new int[n];
        Difference diff = new Difference(nums);

        for (int[] booking : bookings) {
            int i = booking[0] - 1;
            int j = booking[1] - 1;
            diff.increment(i, j, booking[2]);
        }
        return diff.result();
    }
}

// 差分数组类
class Difference {
    private int[] diff; // 差分数组

    public Difference(int[] nums) {
        diff = new int[nums.length];
        diff[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
    }

    /* 给闭区间[i,j]增加val(可以是负数) */
    public void increment(int i, int j, int val) {
        diff[i] += val;
        if (j + 1 < diff.length) {
            diff[j + 1] -= val;
        }
    }

    /* 返回数组结果 */
    public int[] result() {
        int[] res = new int[diff.length];
        res[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            res[i] = res[i - 1] + diff[i];
        }
        return res;
    }

}

class N1109_Solution2 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        // 用差分数组解决
        int[] nums = new int[n];
        for (int[] booking: bookings) {
            int i = booking[0] - 1;
            int j = booking[1] - 1;
            int val = booking[2];
            nums[i] += val;
            if (j + 1 < n) {
                nums[j + 1] -= val;
            }
        }

        // 还原数组
        for (int i = 1; i < n; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}
