/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1); // 哑节点
        ListNode t1 = list1, t2 = list2, t = dummy;
        while (t1 != null && t2 != null) {
            if (t1.val < t2.val) {
                t.next = t1;
                t1 = t1.next;
            } else {
                t.next = t2;
                t2 = t2.next;
            }
            t = t.next;
        }
        if (t1 != null) t.next = t1;
        if (t2 != null) t.next = t2;
        return dummy.next;
    }
}
// @lc code=end

