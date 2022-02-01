/**
 * @author 文进
 * @version 1.0
 * 617.合并二叉树
 */
public class N617_Solution {
}

// 参考算法小抄，思路：将root2二叉树合并到root1二叉树上
class N617_Solution1 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // 如果只有一棵树有，就直接接上去
        // **注意**：如果root1为空，返回的是root2，不是null
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }

        // 两棵树均不为空，叠加值
        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }
}

// 自己的思路：将root1和root2合并到另一个树root上，容易少考虑情况
class N617_Solution2 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // 如果root1和root2均为空，就返回空节点
        if (root1 == null && root2 == null) {
            return null;
        }

        // **注意**：如果root1和root2其中之一不为空，将为空的节点的值设为0
        //          这里不能直接返回其中不为空的节点，不让不能继续递归
        if (root1 != null && root2 == null) {
            root2 = new TreeNode(0);
        }
        if (root1 == null && root2 != null) {
            root1 = new TreeNode(0);
        }

        // 两个节点重叠，将两节点值相加
        TreeNode root = new TreeNode(root1.val + root2.val);
        root.left = mergeTrees(root1.left, root2.left);
        root.right = mergeTrees(root1.right, root2.right);
        return root;
    }
}
