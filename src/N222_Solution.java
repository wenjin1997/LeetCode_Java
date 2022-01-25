/**
 * @author 文进
 * @version 1.0
 * 222.完全二叉树的节点个数
 */
public class N222_Solution {
    public int countNodes(TreeNode root) {
        TreeNode l = root, r = root;
        // 记录左右子树的高度
        int hl = 0, hr = 0;
        while (l != null) {
            l = l.left;
            hl++;
        }
        while (r != null) {
            r = r.right;
            hr++;
        }

        // 如果左右子树的高度相同，则是一棵满二叉树
        if (hl == hr) {
            return (int) Math.pow(2, hl) - 1;
        }
        // 如果左右子树的高度不同，则按照普通二叉树的逻辑进行计算
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}

