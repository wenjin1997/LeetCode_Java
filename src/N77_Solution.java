import java.util.LinkedList;
import java.util.List;

/**
 * @author 文进
 * @version 1.0
 * 77.组合
 */
public class N77_Solution {
    public static void main(String[] args) {
        N77_Solution n77_solution = new N77_Solution();
        System.out.println(n77_solution.combine(4, 2));
    }


    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(n, k, 1);
        return res;
    }

    void backtrack(int n, int k, int start) {
        if (track.size() == k) {
            res.add(new LinkedList<>(track));
            return;
        }

        // 回溯
        for (int i = start; i <= n; i++) {
            // 做选择
            track.addLast(i);
            // 回溯
            backtrack(n, k, i + 1);
            // 撤销选择
            track.removeLast();
        }
    }
}
