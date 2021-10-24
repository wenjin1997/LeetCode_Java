package question_201_210;

/**
 * @author 文进
 * @version 1.0
 * 203.移除链表元素
 *
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
//        // 方法一： 递归
//        // 如果头节点为空，直接返回空
//        if (head == null) {
//            return null;
//        }
//        // 递归过程
//        head.next = removeElements(head.next, val);
//        return head.val == val ? head.next : head;

        // 方法二：迭代
        // 首先，创建一个哑节点，利于最后返回链表
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead; // 这里的temp节点方便遍历删除指定的节点
        while (temp.next != null){ // 这里用temp.next来判断的优点是考虑到head节点为空的情况
            if (temp.next.val == val) {
                temp.next = temp.next.next; // 删除节点
            } else {
                temp = temp.next;
            }
        }
        return dummyHead.next;
    }


    public static void main(String[] args) {
        RemoveLinkedListElements removeLinkedListElements = new RemoveLinkedListElements();
        ListNode head = new ListNode(1, new ListNode(6, new ListNode(3)));
        removeLinkedListElements.removeElements(head, 6);
        // 遍历输出链表
        for (ListNode x = head; x != null; x = x.next){
            System.out.print(x.val + " ");
        }
    }
}
