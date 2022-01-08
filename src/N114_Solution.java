/**
 * @author 文进
 * @version 1.0
 * 114.二叉树展开为链表
 */
public class N114_Solution {
    public void flatten(TreeNode root) {
        /* 基本情况 */
        if (root == null) return;

        /* 如果左右子树已经展开为链表 */
        flatten(root.left);
        flatten(root.right);

        /* 记录二叉树的左右子树 */
        TreeNode left = root.left;
        TreeNode oldRight = root.right;

        /* 将左子树变为右子树 */
        root.left = null;
        root.right = left;

        /* 将原来的右子树接到现在的右子树后面 */
        TreeNode p = root;
        // 将p遍历到现在的右子树末尾
        while (p.right != null) {
            p = p.right;
        }
        // 将原来的右子树接到现在的右子树末尾
        p.right = oldRight;
    }
}
