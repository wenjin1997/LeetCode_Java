/**
 * @author 文进
 * @version 1.0
 * 109.有序链表转换二叉搜索树
 */
public class N109_Solution {

}

// 方法一： 通过中序遍历
class N109_Solution1 {
    public TreeNode sortedListToBST(ListNode head) {
        // 获得链表长度
        int len = 0;
        for (ListNode p = head; p != null; p = p.next) {
            len++;
        }

        cur = head;
        return inorderBuild(0, len - 1);
    }

    ListNode cur; // 表示当前节点

    TreeNode inorderBuild(int left, int right) {
        // base case
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        /**** 下面是中序遍历 ****/
        // 构造左子树
        TreeNode leftTree = inorderBuild(left, mid - 1);
        // 构造根结点
        TreeNode root = new TreeNode(cur.val);
        cur = cur.next; // 更新当前节点
        // 构造右子树
        TreeNode rightTree = inorderBuild(mid + 1, right);

        root.left = leftTree;
        root.right = rightTree;
        return root;
    }
}

// 方法二：通过找到链表的中点
class N109_Solution2 {
    public TreeNode sortedListToBST(ListNode head) {
        return buildTree(head, null);
    }

    // 将链表左闭右开区间[begin, end)构造成二叉树
    TreeNode buildTree(ListNode begin, ListNode end) {
        // 如果begin和end相等，说明是空集
        if (begin == end) {
            return null;
        }
        // 先得到中间节点
        ListNode mid = findMid(begin, end);
        // 构造根结点
        TreeNode root = new TreeNode(mid.val);

        root.left = buildTree(begin, mid);
        root.right = buildTree(mid.next, end);
        return root;
    }

    // 找到链表左闭右开区间[begin, end)的中点，用快慢指针方法
    ListNode findMid(ListNode begin, ListNode end) {
        ListNode slow = begin, fast = begin;
        while (fast != end && fast.next != end) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}