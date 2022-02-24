import java.util.Arrays;
import java.util.Comparator;

/**
 * @author 文进
 * @version 1.0
 * 354.俄罗斯套娃信封问题
 * 思路：先进行排序，第一个维度升序排列，如果第一个维度的值
 *      相同，第二个维度就进行降序排列，这样就将该问题转换
 *      为最长子序列问题（第300题），对第二个维度用最长子序
 *      列的方法求解，可以用动态规划或二分查找。
 */
public class N354_Solution {
    // envelopes = [[w, h], [w, h] ...]
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length; // 表示有多少个信封
        // 按宽度升序排列，如果宽度一样，则按高度降序排列
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                // 返回的值小于0，不改变原来的顺序 a, b
                // 返回值大于0，改变原来的顺序，b, a
                return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
            }
        });
        // 对高度数组寻找最长子序列 LTS
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = envelopes[i][1];
        }

        return lengthOfLTS(height);
    }

    /* 返回 nums 中 LTS 的长度 */
    public int lengthOfLTS(int[] nums) {
        int[] top = new int[nums.length];
        // 牌堆数初始化为0
        int piles = 0;
        for (int i = 0; i < nums.length; i++) {
            // 要处理的扑克牌
            int poker = nums[i];

            /***** 搜索左侧边界的二分查找 *****/
            int left = 0, right = piles;
            while (left < right) {
                int mid = (left + right) / 2;
                if (top[mid] > poker) {
                    right = mid;
                } else if (top[mid] < poker) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            /*******************************/

            // 没找到合适的牌堆，新建一堆
            if (left == piles) piles++;
            // 把这张牌放到牌堆顶
            top[left] = poker;
        }
        // 牌堆数就是 LTS 长度
        return piles;
    }
}
