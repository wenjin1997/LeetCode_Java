/**
 * @author 文进
 * @version 1.0
 * 191.位1的个数
 * 掌握位操作：n & (n - 1 ) 消除 n 的最后一位 1
 */
public class N191_Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0; // 记录结果
        while (n != 0) {
            n = n & (n - 1); // 可以消除 n 中的最后一个 1
            res++;
        }
        return res;
    }
}
