/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第 N 个结点
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 双指针，注意这里 p1 和 p2 指向哑节点，目的是为了处理只有一个节点的情况
        // 防止出现空指针
        ListNode p1 = dummy, p2 = dummy;
        // 先让第一个指针走 n + 1 步
        for (int i = 0; i < n + 1; i++) {
            p1 = p1.next;
        }
        // 再让两个指针同时向前走，第一个指针为空时，第二个指针走到倒数第 n + 1 个位置上
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        // 删除倒数第 n 个节点
        p2.next = p2.next.next;
        return dummy.next;
    }
}
// @lc code=end

