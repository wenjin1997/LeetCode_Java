import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 文进
 * @version 1.0
 * 56.合并区间
 */
public class N56_Solution {
    public static void main(String[] args) {
        int[][] intervals = {{1,3}, {2, 6}, {8, 10}, {15, 18}};
        N56_Solution s = new N56_Solution();
        int[][] ans = s.merge(intervals);
        for (int[] ele : ans) {
            System.out.println("[" + ele[0] +", " + ele[1] + "]");
        }
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;
        List<int[]> res = new ArrayList<>();
        // 按第一个元素排序
        Arrays.sort(intervals, (o1, o2) -> (o1[0] - o2[0]));
        for (int i = 0; i < intervals.length; i++) {
            int L = intervals[i][0], R = intervals[i][1];
            if (res.size() == 0 || res.get(res.size() - 1)[1] < L) {
                res.add(new int[]{L, R});
            } else {
                res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], R);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
