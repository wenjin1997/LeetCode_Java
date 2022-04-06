import java.util.HashSet;

/**
 * @author 文进
 * @version 1.0
 * 202.快乐数
 */
public class N202_Solution {
    public boolean isHappy(int n) {
        // 用集合来避免进入无限循环
        HashSet<Integer> set = new HashSet<>();
        // 出现循环或者为 1 都会跳出循环
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    // 得到下一个数字
    private int getNext(int n) {
        int sum = 0;
        while (n != 0) {
            int num = n % 10;
            sum += num * num;
            n = n / 10;
        }
        return sum;
    }
}

/*
    方法二：快慢指针法
 */
class N202_Solution2 {
    public boolean isHappy(int n) {
        // 用快慢指针来避免进入无限循环
        int lowRunner = n;           // 慢跑者
        int fastRunner = getNext(n); // 快跑者
        while(fastRunner != 1 && lowRunner != fastRunner) {
            lowRunner = getNext(lowRunner);             // 慢跑者向前一步
            fastRunner = getNext(getNext(fastRunner));  // 快跑者向前两步
        }
        return fastRunner == 1;
    }

    // 得到下一个数字
    private int getNext(int n) {
        int sum = 0;
        while (n != 0) {
            int num = n % 10;
            sum += num * num;
            n = n / 10;
        }
        return sum;
    }
}
