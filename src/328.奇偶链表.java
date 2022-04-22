/*
 * @lc app=leetcode.cn id=328 lang=java
 *
 * [328] 奇偶链表
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
    // 方法一：设置一个boolean值判别奇偶链表
    public ListNode oddEvenList1(ListNode head) {
        ListNode l1 = new ListNode(-1);
        ListNode l2 = new ListNode(-1);
        ListNode p1 = l1, p2 = l2;
        ListNode p = head;
        boolean oddflag = true; // 表示当前索引是奇数
        while (p != null) {
            if (oddflag) {
                p1.next = p;
                p = p.next; // 注意这里，要先将 p 移到下一个节点
                p1 = p1.next;
                p1.next = null; // 再将 p1 的 next 置 null
            } else {
                p2.next = p;
                p = p.next;
                p2 = p2.next;
                p2.next = null;
            }
            oddflag = !oddflag;
        }
        p1.next = l2.next;
        return l1.next;
    }

    // 方法二：直接在原链表的基础上分离奇偶链表
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode evenHead = head.next; // 需要先保存，后续需要连接奇偶链表时有用
        ListNode odd = head, even = evenHead;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        // 拼接奇偶链表
        odd.next = evenHead;
        return head;
    }
}
// @lc code=end

