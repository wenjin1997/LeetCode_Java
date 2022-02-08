import java.util.Stack;

/**
 * @author 文进
 * @version 1.0
 * 739.每日温度
 * 思路：单调栈，时间复杂度O(N)，空间复杂度O(N)
 */
public class N739_Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length; // 温度数组的长度
        int[] res = new int[length]; // 结果数组
        Stack<Integer> s = new Stack(); // 单调栈
        for (int i = 0; i < length; i++) {
            // 如果栈不为空，并且温度数组中的数大于栈顶对应元素，就出栈
            while (!s.isEmpty() && temperatures[i] > temperatures[s.peek()]) {
                int prevIndex = s.pop();
                res[prevIndex] = i - prevIndex;
            }
            // 将索引入栈
            s.push(i);
        }
        return res;
    }
}
