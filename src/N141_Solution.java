/**
 * @author 文进
 * @version 1.0
 * 141.环形链表
 */
public class N141_Solution {
    /*
    思路：快慢指针，慢指针每次前进一步，快指针前进两步。
         如果快指针fast最终遇到空指针，说明链表中没有环，如果fast
         最终和slow相遇，说明链表中有环。
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        // 快指针走到末尾时停止
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}
