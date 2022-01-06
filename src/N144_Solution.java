import java.util.LinkedList;
import java.util.List;

/**
 * @author 文进
 * @version 1.0
 * 144.二叉树的前序遍历
 */
public class N144_Solution {
}

class N144_Solution1 {
    public List<Integer> preorderTraversal(TreeNode root) {
        // 分解问题的思路
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        res.add(root.val);
        res.addAll(preorderTraversal(root.left));
        res.addAll(preorderTraversal(root.right));
        return res;
    }
}

/* 遍历二叉树的思路 */
class N144_Solution2 {
    List<Integer> res = new LinkedList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        traverse(root);
        return res;
    }

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // 前序位置
        res.add(root.val);
        traverse(root.left);
        traverse(root.right);
    }
}
