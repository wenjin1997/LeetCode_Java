/**
 * @author 文进
 * @version 1.0
 * 226.翻转二叉树
 */
public class N226_Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        // 交换左右结点
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // 递归交换左右子结点
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
