import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 文进
 * @version 1.0
 * 145.二叉树的后序遍历
 */
public class N145_Solution {
    List<Integer> res = new ArrayList<>(); // 保存输出结果

    public List<Integer> postorderTraversal(TreeNode root) {
        traverse(root);
        return res;
    }

    void traverse(TreeNode root) {
        // base case
        if (root == null) {
            return;
        }

        traverse(root.left); // 先遍历左子树
        traverse(root.right); // 遍历右子树
        /*** 后序遍历位置 ***/
        res.add(root.val); // 将root的值加入到结果中
    }
}
