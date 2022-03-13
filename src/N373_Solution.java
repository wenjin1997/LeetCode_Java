import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author 文进
 * @version 1.0
 * 373.查找和最小的K对数字
 */
public class N373_Solution {
}

/*
方法一：优先队列
时间复杂度：O(klogk)，k 是选择的数对的数目。
空间复杂度：O(k)
利用堆的特性可求出待选范围最小数对索引为 (ai, bi)，则将新的待选数对 (ai + 1, bi), (ai, bi + 1)
加入到堆中，直到选出 k 个数对即可。
为了防止重复，可以先将 nums1 的前 k 个索引数对(0,0),(1,0),...,(k - 1, 0)加入到队列中，从队列中取出
元素(x,y)时，只需将 nums2 的索引增加，这样就避免了重复加入元素的问题。
 */
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // 优先队列中存放的是数组的指标
        PriorityQueue<int[]> pq = new PriorityQueue<>(k, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]]; // 升序方式
            }
        });
        List<List<Integer>> ans = new ArrayList<>();
        int m = nums1.length;
        int n = nums2.length;
        for (int i = 0; i < Math.min(m, k); i++) {
            pq.offer(new int[]{i, 0});
        }
        while (k-- > 0 && !pq.isEmpty()) {
            int[] idxPair = pq.poll();
            List<Integer> list = new ArrayList<>();
            list.add(nums1[idxPair[0]]);
            list.add(nums2[idxPair[1]]);
            ans.add(list);
            if (idxPair[1] + 1 < n) {
                pq.offer(new int[]{idxPair[0], idxPair[1] + 1});
            }
        }

        return ans;
    }
}
