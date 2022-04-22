/*
 * @lc app=leetcode.cn id=82 lang=java
 *
 * [82] 删除排序链表中的重复元素 II
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        // 设置哑节点
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode cur = dummyNode;

        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int curVal = cur.next.val;
                // 逐个删除节点
                while (cur.next != null && cur.next.val == curVal) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }

        return dummyNode.next;     
    }
}
// @lc code=end

