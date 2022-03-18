/**
 * @author 文进
 * @version 1.0
 * 268.丢失的数字
 */
public class N268_Solution {
    /*
    方法：数学
    思路：前 n 个数求和公式为 n * (n + 1) / 2
         求数组的和sum，用前n个数的和减去数组的和记得到丢失的数字
    时间复杂度：O(n)
    空间复杂度：O(1)
     */
    public int missingNumber(int[] nums) {
        int n = nums.length, sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        return n * (n + 1) / 2 - sum;
    }

    /*
    方法：异或运算
    思路： x ^ 0 = x
          x ^ x = 0
          1 ^ 1 = 0
          1 ^ 0 = 1
          0 ^ 0 = 0
          0 ^ 1 = 1
          异或运算满足交换律与结合律
          该方法会比求和的数学方法快，数学方法需要额外的空间，而且如果数字较大，可能溢出
     时间复杂度：O(n)
     空间复杂度：O(1)
     */
    public int missingNumber2(int[] nums) {
        int xor = 0; // 异或结果
        for (int i = 0; i < nums.length; i++) {
            xor = xor ^ (i + 1) ^ nums[i];
        }
        return xor;
    }

}
