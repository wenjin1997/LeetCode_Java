/**
 * @author 文进
 * @version 1.0
 * 236.二叉树的最近公共祖先
 */
public class N236_Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 基本情况
        if (root == null) return null;
        if (root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 情况1
        if (left != null && right != null) {
            return root;
        }

        // 情况2
        if (left == null && right == null) {
            return null;
        }

        // 情况3
        return left == null ? right : left;

    }
}
