/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        int nextVal = 0; // 保存进位
        while (l1 != null || l2 != null) {
            int val1 = (l1 == null) ? 0 : l1.val;
            int val2 = (l2 == null) ? 0 : l2.val;
            int curVal = (val1 + val2 + nextVal) % 10;
            p.next = new ListNode(curVal);
            nextVal = (val1 + val2 + nextVal) / 10;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            p = p.next;
        }
        // 如果还有进位
        if (nextVal != 0) {
            p.next = new ListNode(nextVal);
        }
        return dummy.next;
    }
}
// @lc code=end

