/**
 * @author 文进
 * @version 1.0
 * 701.二叉搜索树中的插入操作
 * 思路：《算法》P253
 */
public class N701_Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.val) root.left = insertIntoBST(root.left, val);
        else if (val > root.val) root.right = insertIntoBST(root.right, val);

        return root;
    }
}
