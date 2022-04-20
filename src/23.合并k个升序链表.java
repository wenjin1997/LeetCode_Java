/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个升序链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> {
            return a.val - b.val;
        });
        ListNode dummy = new ListNode(-1), temp = dummy;
        for (ListNode list : lists) {
            // 这里要小心，为了防止后续处理空指针的情况，队列中只加入非空的链表
            if (list != null) {
                pq.offer(list);
            }
            
        }
        while (!pq.isEmpty()) {
            ListNode t = pq.poll();
            temp.next = t;
            t = t.next;
            if (t != null) pq.offer(t); // 注意非空链表才能加入优先队列
            temp = temp.next;  
        }
        return dummy.next;
    }
}
// @lc code=end

