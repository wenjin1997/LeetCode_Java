package question_1_500;

/**
 * @author 文进
 * @version 1.0
 * 238.除自身以外数组的乘积
 */
public class N238_ProductOfArrayExceptSelf {

}

class N238_Solution1 {
    public int[] productExceptSelf(int[] nums) {
        // 方法一：分别用前缀乘积数组和后缀乘积数组求解
        int N = nums.length;
        int[] left = new int[N];
        int[] right = new int[N];
        int[] output = new int[N];

        left[0] = 1;
        right[N - 1] = 1;
        for (int i = 1; i < N; i++) {
            left[i] = nums[i - 1] * left[i - 1];
            right[N - i - 1] = right[N - i] * nums[N - i];
        }

        // 输出output[i] = 前缀之积 * 后缀之积
        for (int i = 0; i < N; i++) {
            output[i] = left[i] * right[i];
        }

        return output;
    }
}

class N238_Solution2 {
    public int[] productExceptSelf(int[] nums) {
        // 方法二： 优化方法一，用常数空间解决
        //        后缀用一个变量来表示
        int N = nums.length;
        int[] output = new int[N];
        output[0] = 1;
        int r = 1; // 变量表示后缀之积

        for (int i = 1; i < N; i++) {
            output[i] = output[i - 1] * nums[i - 1];
        }

        for (int i = N - 2; i >= 0; i--) {
            r = r * nums[i + 1];
            output[i] = output[i] * r;
        }

        return output;
    }
}





