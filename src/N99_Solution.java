/**
 * @author 文进
 * @version 1.0
 * 99.恢复二叉搜索树
 */
public class N99_Solution {
}

// **注意**
// 二叉搜索树中中序遍历结果是有序的
class N99_Solution1 {
    // 分别记录两个需要被交换的节点
    TreeNode first = null, second = null;
    TreeNode prev = new TreeNode(Integer.MIN_VALUE); // 为了保证中序遍历的有序性

    public void recoverTree(TreeNode root) {
        inorderTraverse(root);
        // 交换first和second的值
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    void inorderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }

        inorderTraverse(root.left);

        // ***中序遍位置***
        if (root.val < prev.val) {
            // first只需要记录一次，第一次出现顺序不对的时候
            if (first == null) {
                // 第一个错位节点是prev
                first = prev;
            }
            second = root;
        }
        prev = root;

        inorderTraverse(root.right);
    }
}

