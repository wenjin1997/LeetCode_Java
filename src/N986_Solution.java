import java.util.ArrayList;
import java.util.List;

/**
 * @author 文进
 * @version 1.0
 * 986.区间列表的交集
 */
public class N986_Solution {
    public static void main(String[] args) {
        int[][] firstList = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
        int[][] secondList = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};
        N986_Solution n986_solution = new N986_Solution();
        int[][] ans = n986_solution.intervalIntersection(firstList, secondList);
        for (int[] ele : ans) {
            System.out.println("[" + ele[0] +", " + ele[1] + "]");
        }

    }
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res = new ArrayList<>();
        int i = 0, j = 0;
        int L1, R1, L2, R2;
        while (i < firstList.length && j < secondList.length) {
            // 第一个数组 [L1, R1]
            // 第二个数组 [L2, R2]
            L1 = firstList[i][0];
            R1 = firstList[i][1];
            L2 = secondList[j][0];
            R2 = secondList[j][1];
            // 存在交集，特别注意这里是如何得出的，画图
            if (L1 <= R2 && L2 <= R1) {
                res.add(new int[] {Math.max(L1, L2), Math.min(R1, R2)});
            }
            // 指针移动
            if (R1 <= R2) i++;
            else          j++;
        }
        return res.toArray(new int[res.size()][]);
    }
}
