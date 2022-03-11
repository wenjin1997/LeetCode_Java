import java.util.PriorityQueue;

/**
 * @author 文进
 * @version 1.0
 * 215.数组中的第K个最大元素
 */
public class N215_Solution {
    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        System.out.println(N215_Solution.findKthLargest(nums, 2));
    }
    public static int findKthLargest(int[] nums, int k) {
        // 优先队列，Java中实现的是小顶堆
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(num); // 先将元素放入
            // 如果堆中元素多余 k 个，删除堆顶元素，也就是最小的元素
            if (pq.size() > k) {
                pq.poll();
            }
        }
        // 第 k 大的元素即是堆顶元素
        return pq.peek();
    }


}
