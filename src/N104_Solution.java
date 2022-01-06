/**
 * @author 文进
 * @version 1.0
 * 104.二叉树的最大深度
 */
public class N104_Solution {
}
class N104_Solution1 {
    public int maxDepth(TreeNode root) {
        // 分解问题的思路
        if (root == null) return 0;
        // 利用定义，计算二叉树的左右子树的深度
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        int res = Math.max(leftDepth, rightDepth) + 1;

        return res;
    }
}

class N104_Solution2 {
    // 遍历二叉树的方法
    // 记录最大深度
    int res = 0;
    // 记录遍历到节点的深度
    int depth = 0;

    public int maxDepth(TreeNode root) {
        traverse(root);
        return res;
    }
    // 二叉树遍历框架
    void traverse(TreeNode root) {
        if (root == null) {
            res = Math.max(res, depth);
            return;
        }
        // 前序位置
        depth++;
        traverse(root.left);
        traverse(root.right);
        // 后序位置
        depth--;
    }
}