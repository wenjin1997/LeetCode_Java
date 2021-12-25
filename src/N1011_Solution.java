/**
 * @author 文进
 * @version 1.0
 * 1011.在D天内送达包裹的能力
 * 思路：二分查找
 */
public class N1011_Solution {
    public static void main(String[] args) {

    }
}

// 参考算法小抄
class N1011_Solution_Reference {
    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 1, 1};
        System.out.println(shipWithinDays(weights, 4));
    }
    static int shipWithinDays(int[] weights, int days) {
        // 注意：这里left和right不能乱取，不然可能造成死循环
        //      left取数组中的最大值，right取数组的各元素之和
        int left = 0;
        int right = 1;
        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }
        // 二分查找，取左边界
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (f(weights, mid) <= days) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    // 定义：当运载能力为 x 时，需要 f(x) 天运完所有货物
    // f(x) 随着 x 的增加单调递减
    // Remark: 注意这里的方法
    static int f(int[] weights, int x) {
        int days = 0;
        for (int i = 0; i < weights.length; ) {
            // 尽可能多装货物
            int cap = x;
            while (i < weights.length) {
                if (cap < weights[i]) break;
                else cap -= weights[i];
                i++;
            }
            days++;
        }
        return days;
    }
}
