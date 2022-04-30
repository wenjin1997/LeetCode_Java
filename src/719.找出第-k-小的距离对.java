/*
 * @lc app=leetcode.cn id=719 lang=java
 *
 * [719] 找出第 k 小的距离对
 */

// @lc code=start
class Solution {
    // 方法一：堆，优先队列，会超出时间限制
    public int smallestDistancePair1(int[] nums, int k) {
        // 首先给数组排序
        Arrays.sort(nums);
        // 优先队列
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
            return nums[a.nei] - nums[a.root] - (nums[b.nei] - nums[b.root]);
        });
        for (int i = 0; i < nums.length - 1; i++) {
            pq.offer(new Node(i, i + 1));
        }
        // 取出第 k 小的距离对
        Node cur = null;
        for (int i = k; i > 0; i--) {
            cur = pq.poll();
            if (cur.nei + 1 < nums.length) {
                pq.offer(new Node(cur.root, cur.nei + 1));
            }
        }
        return nums[cur.nei] - nums[cur.root];
    }

    // 方法二：二分查找 + 双指针
    public int smallestDistancePair(int[] nums, int k) {
        // 首先给数组排序
        Arrays.sort(nums);
        int lo = 0;
        int hi = nums[nums.length - 1] - nums[0]; // 最大距离
        while (lo < hi) {
            int guess = lo + (hi - lo) / 2; // 猜测的二分距离
            int count = 0; // 记录数组中距离 <= guess 的数对
            // 双指针维护来计算 count
            int left = 0;
            for (int right = 0; right < nums.length; right++) {
                // 维护 left 是 <= guess 的左边指针的最小数
                while (nums[right] - nums[left] > guess) left++;
                // 注意：如果 nums[right] - nums[left] <= guess，则
                // nums[left + 1, left + 2, ..., right - 1, right] - nums[left] <= guess
                // 因此满足的数对有 right - (left + 1) + 1 = right - left 个，需要加到 count 中
                count += right - left;
            }
            // 如果数组中 <= guess 的数对 >= k，说明数组中第 k 小的距离对的和最多为 guess
            // 如果数组中 <= guess 的数对 < k，说明当前猜的数一定小了，第 k 小的距离对的距离一定比 guess 大
            if (count >= k) hi = guess;
            else lo = guess + 1;
        }
        return lo;
    }
}

// 方法一需要的类
class Node {
    int root;
    int nei;   // 最小距离对的下标 (root, nei)

    public Node(int r, int n) {
        root = r;
        nei = n;
    }
}
// @lc code=end

