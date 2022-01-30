/**
 * @author 文进
 * @version 1.0
 * 101.对称二叉树
 */
public class N101_Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        // 检查两个子树是否对称
        return check(root.left, root.right);

    }
    boolean check(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right; // 如果两个均为空，则返回true
        }
        // 要保证两个节点均为同一个根结点
        if (left.val != right.val) {
            return false;
        }
        return check(left.left, right.right) && check(left.right, right.left);
    }
}
