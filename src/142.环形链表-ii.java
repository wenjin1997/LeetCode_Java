/*
 * @lc app=leetcode.cn id=142 lang=java
 *
 * [142] 环形链表 II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break; // 如果相遇，说明有环，跳出循环
        }
        
        // 出现空指针，说明链表中没有环
        if (fast == null || fast.next == null) {
            return null;
        }

        // 让快慢指针中的其中一个指向头节点
        // 然后一起向前走直到相遇，相遇点就是进入环的第一个结点
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow; 
    }
}
// @lc code=end

