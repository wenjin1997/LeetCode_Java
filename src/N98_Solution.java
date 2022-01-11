/**
 * @author 文进
 * @version 1.0
 * 98.验证二叉搜索树
 */
public class N98_Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    /**
     * 以root为根节点需要满足min.val < root.val < max.val
     */
    boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min.val) return false;
        if (max != null && root.val >= max.val) return false;

        // 限定左子树的最大值是 root.val，右子树的最小值是 root.val
        return isValidBST(root.left, min, root)
                && isValidBST(root.right, root, max);
    }
}
