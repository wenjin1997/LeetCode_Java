/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] 回文链表
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
    // 这种方法会破坏原来链表的结构
    public boolean isPalindrome(ListNode head) {
        // 先找到链表的中点，用快慢指针
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 如果fast不为空，说明链表长度为奇数， slow 指针还需要往前走一步
        if (fast != null) {
            slow = slow.next;
        }

        // 反转链表的后半部分，然后后前半部分一一比较值是否相等
        ListNode right = reverse(slow);
        ListNode left = head;
        while (right != null) {
            if (left.val != right.val) return false;
            right = right.next;
            left = left.next;
        }
        return true;
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

