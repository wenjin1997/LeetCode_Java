package question_81_90;

/**
 * @author 文进
 * @version 1.0
 * 83.删除排序链表中的重复元素
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(-200);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null) {
            if (temp.val == temp.next.val) {
                temp.next = temp.next.next;
                head = head.next;
            } else {
                temp = temp.next;
            }
        }
        return dummyHead.next;
    }


    // 方法二：参考算法小抄，快慢指针法
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null) return null;
        ListNode slow = head, fast = head;
        while (fast != null) {
            if (fast.val != slow.val) {
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        // 断开与后面重复元素的链接
        slow.next = null;
        return head;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList s = new RemoveDuplicatesFromSortedList();
        ListNode head = new ListNode(7, new ListNode(7, new ListNode(8)));
        ListNode removedList = s.deleteDuplicates(head);
        for (ListNode x = removedList ; x != null; x = x.next){
            System.out.print(x.val + " ");
        }
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {this.val = val;}
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
