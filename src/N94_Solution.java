import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.List;
/**
 * @author 文进
 * @version 1.0
 * 94.二叉树的中序遍历
 *    中序遍历：先遍历左子树，再遍历根结点，
 *            最后遍历右子树。
 */
public class N94_Solution {
    List<Integer> res = new ArrayList<>(); // 记录输出结果

    public List<Integer> inorderTraversal(TreeNode root) {
        traverse(root);
        return res;
    }

    // 递归进行中序遍历
    void traverse(TreeNode root) {
        // base case
        if (root == null) {
            return;
        }

        traverse(root.left);
        res.add(root.val);  // 中序遍历位置
        traverse(root.right);
    }
}
