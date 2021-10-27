package question_21_30;
/**
 * @author 文进
 * @version 1.0
 * 21. 合并两个有序链表
 *
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
class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        // 迭代法
//        ListNode prehead = new ListNode(-1); // 便于返回结点
//        ListNode prev = prehead;
//        while (l1 != null && l2 != null){ // 注意要单个单个结点进行大小比较
//            if (l1.val <= l2.val) {
//                prev.next = l1;
//                l1 = l1.next;
//            } else {
//                prev.next = l2;
//                l2 = l2.next;
//            }
//            prev = prev.next;
//        }
//        prev.next = l1 == null ? l2 : l1; // 如果还有结点没有比较，进行合并
//        return prehead.next;

        // 递归法
        if(l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(0, new ListNode(3, new ListNode(4)));
        ListNode mergeList = mergeTwoSortedLists.mergeTwoLists(l1,l2);
        for (ListNode x = mergeList; x != null; x = x.next){
            System.out.print(x.val + " ");
        }
    }
}

