package question_1_500;

/**
 * @author 文进
 * @version 1.0
 * 234.回文链表
 * 思路：1.找到链表的中点
 *      2.反转链表的后半段，返回反转链表的头结点
 *      3.比较反转后的后半段的链表与前半段链表
 *      4.再还原后半段链表，也就是再反转一遍（最好不要更改了原来的链表）
 *      5.返回结果
 * 复杂度：时间O(n)，空间O(1)
 */
public class N234_PalindromeLinkedList {

}

class N234_Solution {
    public boolean isPalindrome(ListNode head) {

        ListNode firstHalf = endOfFirstHalf(head);
        ListNode secondHalf = reverseList(firstHalf.next);

        // 判断是否是回文
        ListNode p1 = head;
        ListNode p2 = secondHalf;
        boolean result = true;
        while(result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        firstHalf.next = reverseList(secondHalf);
        return result;
    }

    private ListNode reverseList(ListNode head) {
        // 递归法
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    private ListNode endOfFirstHalf(ListNode head) { // 找到链表的中点
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}


