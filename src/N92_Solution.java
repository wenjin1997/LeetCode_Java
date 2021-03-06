/**
 * @author 文进
 * @version 1.0
 * 92.反转链表II
 */
public class N92_Solution {
}

class N92_Solution1 {
    // 递归法
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // base case
        if (m == 1) {
            return reverseN(head, n);
        }
        // 前进到反转的起点触发 base case
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    ListNode successor = null; // 后驱节点
    // 反转以 head 为起点的 n 个节点，返回新的头结点
    ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            // 记录第 n + 1 个节点
            successor = head.next;
            return head;
        }
        // 以 head.next 为起点，需要反转前 n - 1 个节点
        ListNode last = reverseN(head.next, n - 1);

        head.next.next = head;
        // 让反转之后的 head 节点和后面的节点连起来
        head.next = successor;
        return last;
    }
}

class N92_Solution2 {
    // 迭代法
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head;
        ListNode cur = head;
        ListNode leftNode = head;
        int curIndex = 1;

        while (curIndex < left) {
            leftNode = cur;
            cur = cur.next;
            curIndex++;
        }

        ListNode prev = leftNode;
        ListNode curHead = cur;

        while (curIndex < right) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            curIndex++;
        }

        ListNode rightNode = cur.next;
        cur.next = prev;

        curHead.next = rightNode;

        // 如果左边节点是第一个，就要返回 cur
        if (left == 1) {
            return cur;
        } else {
            leftNode.next = cur;
        }

        return head;
    }
}
