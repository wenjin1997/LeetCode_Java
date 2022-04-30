/*
 * @lc app=leetcode.cn id=658 lang=java
 *
 * [658] 找到 K 个最接近的元素
 */

// @lc code=start
class Solution {
    // 方法一：优先队列
    public List<Integer> findClosestElements1(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            // 如果和 x 的距离相等，则返回更小的那个数
            if (Math.abs(a - x) == Math.abs(b - x)) {
                return a - b;
            }
            else return Math.abs(a - x) - Math.abs(b - x);
        });
        for (int ele : arr) {
            pq.offer(ele);
        }
        // 取出 K 个元素
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll();
        }
        Arrays.sort(ans);
        List<Integer> res = new ArrayList<>();
        for (int ele : ans) {
            res.add(ele);
        }
        return res;
    }

    // 方法二：双指针（排除法）
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // 在原数组中，需要找到靠近 x 的 k 个数，因此需要删除数组中 size - k 个数
        int size = arr.length;
        int removeNum = size - k;
        // 双指针维护保留的元素
        int left = 0, right = size - 1;
        while (removeNum > 0) {
            // int comp = Math.abs(arr[left] - x) - Math.abs(arr[right] - x);
            int comp = (x - arr[left]) - (arr[right] - x);
            if (comp < 0) { // 说明 arr[left] 更接近 x，需要删除 arr[right]
                right--;
            } else if (comp > 0) {
                left++;
            } else { // arr[left] 和 arr[right] 到 x 的距离相等，则保留更小的那个数
                right--;
            }
            removeNum--;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            ans.add(arr[i]);
        }
        return ans;
    }
}
// @lc code=end

