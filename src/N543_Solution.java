/**
 * @author 文进
 * @version 1.0
 * 543.二叉树的直径
 */
public class N543_Solution {
}

/*后序遍历的方法*/
class N543_Solution1 {
    // 记录二叉树的最大直径
    int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxDiameter;
    }
    int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        // 后序位置顺便记录最大直径
        int depth = leftDepth + rightDepth;
        maxDiameter = Math.max(depth, maxDiameter);

        return Math.max(leftDepth, rightDepth) + 1;
    }
}

/*简单粗暴的方法，效率不高*/
class N543_Solution2 {
    // 记录二叉树的最大直径
    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        traverse(root);
        return maxDiameter;
    }
    // 遍历二叉树
    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // 对每个节点计算直径
        int leftDiameter = MaxDepth(root.left);
        int rightDiameter = MaxDepth(root.right);
        int myDiameter = leftDiameter + rightDiameter;

        // 更新全局最大直径
        maxDiameter = Math.max(myDiameter, maxDiameter);

        traverse(root.left);
        traverse(root.right);
    }
    // 计算二叉树的最大深度
    int MaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = MaxDepth(root.left);
        int rightDepth = MaxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }
}