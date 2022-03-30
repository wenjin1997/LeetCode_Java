import javax.sound.midi.Track;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author 文进
 * @version 1.0
 * 22.括号生成
 */
public class N22_Solution {
    public static void main(String[] args) {
        N22_Solution n22_solution = new N22_Solution();
        System.out.println(n22_solution.generateParenthesis(3));
    }


    List<String> res = new ArrayList<>(); // 记录结果
    Stack<String> stack = new Stack<>();
    public List<String> generateParenthesis(int n) {
        backtrack(n, n);
        return res;
    }

    /*
    可用的左括号数量为 left 个，可用的右括号数量为 right 个
     */
    void backtrack(int left, int right) {
        // 若左括号剩余的多，说明不合法
        if (right < left) return;
        // 数量小于 0 肯定不合法
        if (right < 0 || left < 0) return;
        // 左右括号都恰好用完，这可以得到合法的括号组合
        if (left == 0 && right == 0) {
            StringBuilder sb = new StringBuilder();
            for (String str : stack) {
                sb.append(str);
            }
            res.add(sb.toString());
            return;
        }

        // 尝试放一个左括号
        stack.push("("); // 做选择
        backtrack(left - 1, right);
        stack.pop(); // 撤销选择

        // 尝试放一个右括号
        stack.push(")"); // 做选择
        backtrack(left, right - 1);
        stack.pop(); // 撤销选择
    }
}
