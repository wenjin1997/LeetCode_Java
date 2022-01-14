import java.util.LinkedList;
import java.util.List;

/**
 * @author 文进
 * @version 1.0
 * 95.不同的二叉搜索树II
 */
public class N95_Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new LinkedList<TreeNode>();
        // 构造闭区间[1,n]之间的BST
        return build(1, n);
    }

    /** 构造闭区间[lo,...,hi]之间的BST **/
    List<TreeNode> build(int lo, int hi) {
        List<TreeNode> res = new LinkedList<>();
        if (lo > hi) {
            res.add(null);
            return res;
        }
        // 1. 穷尽root节点的所有可能
        for (int i = lo; i <= hi; i++) {
            // 2. 递归构造出左右子树的合法BST
            List<TreeNode> leftTree = build(lo, i - 1);
            List<TreeNode> rightTree = build(i + 1, hi);
            // 3. 给root节点穷举所有的左右子树的组合
            for (TreeNode left : leftTree) {
                for (TreeNode right : rightTree) {
                    // i 作为根结点root的值
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }

        return res;
    }
}


