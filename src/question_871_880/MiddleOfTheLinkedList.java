package question_871_880;

/**
 * @author 文进
 * @version 1.0
 * 876.链表的中间结点
 */
public class MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
//        // 方法一：单指针法
//        // 获取链表的长度
//        int length = 0;
//        for (ListNode x = head; x != null; x = x.next) {
//            length++;
//        }
//        int N = length / 2; // 取到第length / 2 - 1个元素，但是head指针只移动length / 2次
//        while (N > 0) {
//            head = head.next;
//            N--;
//        }
//        return head;

        // 方法二：快慢指针法
        ListNode fast = head; // 快指针，一次移动2个结点
        ListNode slow = head; // 慢指针，一次只移动一个结点
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        MiddleOfTheLinkedList m = new MiddleOfTheLinkedList();
        ListNode head = new ListNode(1, new ListNode(2,
                new ListNode(3, new ListNode(4, new ListNode(5,new ListNode(6))))));
        ListNode middleList = m.middleNode(head);
        for (ListNode x = middleList; x != null; x = x.next) {
            System.out.print(x.val + " ");
        }
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