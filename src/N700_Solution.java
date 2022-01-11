/**
 * @author 文进
 * @version 1.0
 * 700.二叉搜索树中的搜索
 */
public class N700_Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        int rootVal = root.val;
        if (val < rootVal) {
            return searchBST(root.left, val);
        }
        else if (val > rootVal) {
            return searchBST(root.right, val);
        }
        else return root;
    }
}
