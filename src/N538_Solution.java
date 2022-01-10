/**
 * @author 文进
 * @version 1.0
 * 538.把二叉搜索树转换为累加树
 * 思路：利用二叉搜索数的中序遍历
 *      需要改变的是这里要求降序排列，因此先遍历右子树，
 *      再遍历左子树
 */
public class N538_Solution {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }
    void traverse(TreeNode root) {
        // base case
        if (root == null) {
            return;
        }
        // 递归，先遍历右子树
        traverse(root.right);

        // 中序遍历位置
        sum += root.val;
        root.val = sum;

        // 遍历左子树
        traverse(root.left);
    }
}
