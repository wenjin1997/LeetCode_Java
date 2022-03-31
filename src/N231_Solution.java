/**
 * @author 文进
 * @version 1.0
 * 231.2的幂
 */
public class N231_Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        // 如果一个数是2的幂，则它的二进制数中只含有一个1，
        // n & (n - 1) 可以消除 n 的最后一个 1， 消除后的结果应该为 0
        return (n & (n - 1)) == 0;
    }
}
