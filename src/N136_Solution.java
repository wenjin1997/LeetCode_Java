// 136.只出现一次的数字
// 思路：利用异或运算
public class N136_Solution {
    public int singleNumber(int[] nums) {
    int res = 0;
    for (int n : nums) {
        res ^= n;
    }
    return res;
    }
}
