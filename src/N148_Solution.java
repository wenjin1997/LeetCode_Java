/**
 * @author 文进
 * @version 1.0
 * 148.排序链表
 */
public class N148_Solution {
}

/*  自顶向下归并排序
 *  时间复杂度：O(NlogN)
 *  空间复杂度：O(logN),其中 N 是链表的长度。空间复杂度主要取决于递归调用的栈空间。
 */
class N148_Solution1 {
    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    public ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        // 通过快慢指针找链表的中点
        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode list1 = sortList(head, mid);
        ListNode list2 = sortList(mid, tail);
        ListNode sorted = merge(list1, list2);
        return sorted;
    }

    // 合并两个链表
    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0); // 哑节点
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }
        return dummyHead.next;
    }
}

/*
自底向上归并排序
时间复杂度：O(NlogN)
空间复杂度: O(1)
 */
class N148_Solution2 {
    // 自底向上的归并排序
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return head;
        }

        // 得到链表的长度
        int length = 0; // 链表的长度
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }


        ListNode dummyHead = new ListNode(0, head); // 便于返回结果
        for (int subLength = 1; subLength < length; subLength <<= 1) {
            ListNode prev = dummyHead, curr = dummyHead.next;
            // 1. 将原来的链表分割成若干个 subLength 长度的子链表，
            // 2. 合并相邻的两个 subLength 链表
            // 3. 直到遍历到链表结尾
            while (curr != null) {
                // 第1个子链表
                ListNode head1 = curr;
                for (int i = 1; i < subLength && curr.next != null; i++) {
                    curr = curr.next;
                }
                // 第2个子链表
                ListNode head2 = curr.next;
                curr.next = null; // 截断第一个链表
                curr = head2; // 当前节点为head2，开始截断第2个链表
                // curr.next 不能为空，因为这是第2个链表，要保证都有元素，有值
                for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode next = null; // 便于保存下次curr节点开始的地方
                if (curr != null) {
                    next = curr.next;
                    curr.next = null; // 截断第2个链表
                }

                ListNode merged = merge(head1, head2);
                prev.next = merged; // 将排序后的链表连接起来
                // 将prev指针移动到下一个要分割的子链表处，便于后面合并
                while (prev.next != null) {
                    prev = prev.next;
                }

                curr = next;
            }

        }
        return dummyHead.next;

    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0); // 便于返回结果
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }

        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }
        return dummyHead.next;
    }
}
