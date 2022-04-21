/*
 * @lc app=leetcode.cn id=143 lang=java
 *
 * [143] 重排链表
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
    public void reorderList(ListNode head) {
        // 找到中间结点
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 反转后半段链表
        ListNode list2 = reverse(slow.next);
        // 注意：这里一定要断开前一个链表
        slow.next = null;

        // 穿插两个链表，将 list2 中的节点穿插到 list1 中
        ListNode cur2 = list2;
        ListNode cur1 = head;
        while (cur2 != null) {
            ListNode cur2Next = cur2.next;
            // 穿插
            cur2.next = cur1.next;
            cur1.next = cur2;
            // 更新节点值
            cur1 = cur2.next;
            cur2 = cur2Next;
        }
    }

    // 反转链表
    ListNode reverse(ListNode head) {
        ListNode prev = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
// @lc code=end

