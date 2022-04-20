/*
 * @lc app=leetcode.cn id=160 lang=java
 *
 * [160] 相交链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        // p1 走完第一个链表后，就遍历第二个链表
        // p2 走完第二个链表后，就遍历第一个链表
        // 当 p1 和 p2 相遇时，恰好是相交链表的起点
        // 如果两个链表未相交，则相遇时都是 null
        while (p1 != p2) {
            if (p1 == null) p1 = headB;
            else            p1 = p1.next;
            if (p2 == null) p2 = headA;
            else            p2 = p2.next;
        }
        return p1;
    }
}
// @lc code=end

