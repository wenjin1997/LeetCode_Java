import java.util.Arrays;

/**
 * @author 文进
 * @version 1.0
 * 1288.删除被覆盖区间
 */
public class N1288_Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        // 按照起点升序排列，终点相同时降序排列
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });

        // 记录合并区间的起点和终点
        int left = intervals[0][0];
        int right = intervals[0][1];

        int res = 0;
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            // 情况一：找到覆盖区间
            if (left <= interval[0] && right >= interval[1]) {
                res++;
            }
            // 情况二：找到相交区间，合并
            if (right >= interval[0] && right <= interval[1]) {
                right = interval[1];
            }
            // 情况三：完全不相交，更新起点和终点
            if (right < interval[0]) {
                left = interval[0];
                right = interval[1];
            }
        }

        return intervals.length - res;
    }
}
