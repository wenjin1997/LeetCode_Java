/**
 * @author 文进
 * @version 1.0
 * 326.3的幂
 */
public class N326_Solution {
}

/*
    方法一：递归法
 */
class N326_Solution1 {
    public boolean isPowerOfThree(int n) {
        if (n == 3 || n == 1) {
            return true;
        }

        if (n == 0 || n == 2) {
            return false;
        }

        // 保证能被3整除并且商为3的幂
        return (n % 3 == 0) && isPowerOfThree(n / 3);
    }
}

/*
    方法二：试除法
           一直除以3，直到为1，说明为3的幂
 */

class N326_Solution2 {
    public boolean isPowerOfThree(int n) {
        while(n != 0 && n % 3 == 0) {
            n = n / 3;
        }
        return n == 1;
    }
}
