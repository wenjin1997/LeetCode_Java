package question_201_210;

/**
 * @author 文进
 * @version 1.0
 * 206. 反转链表
 * <p>
 * <p>
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
//        // 方法一： 迭代法
//        ListNode prev = null;
//        ListNode curr = head;
//        while (curr != null) {
//            ListNode next = curr.next;
//            curr.next = prev;
//            prev = curr;
//            curr = next;
//        }
//        return prev;

        // 方法二：递归法
        if (head == null || head.next == null){ // 当为空链表或者链表中只有一个元素时
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(6, new ListNode(3)));
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        head = reverseLinkedList.reverseList(head);
        // 遍历输出链表
        for (ListNode x = head; x != null; x = x.next) {
            System.out.print(x.val + " ");
        }
    }
}