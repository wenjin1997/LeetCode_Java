/**
 * @author 文进
 * @version 1.0
 * 450. 删除二叉搜索树中的节点
 */
public class N450_Solution {
}

/**
 * 参考《算法》P261
 * 利用后继节点，辅助函数deleteMin()、min()
 */
class N450_Solution1 {
    public TreeNode deleteNode(TreeNode root, int key) {
        return delete(root, key);
    }

    /* 删除节点 */
    TreeNode delete(TreeNode x, int key) {
        if (x == null) {
            return null;
        }
        if (key < x.val) {
            x.left = delete(x.left, key);
        } else if (key > x.val) {
            x.right = delete(x.right, key);
        } else { // x节点就是要删除的节点
            if (x.left == null) return x.right;
            if (x.right == null) return x.left;

            // 1. 将指向即将被删除的节点的连接保存为t
            TreeNode t = x;
            // 2. 将x指向它的后继节点min(t.right)
            x = min(x.right);
            // 3. 将x的右链接指向deleteMin(t.right)，也就是
            //    在删除后所有节点仍然都大于x.val的子二叉搜索树
            x.right = deleteMin(t.right);
            // 4. 将x的左链接（本为空）设为t.left（其下所有的
            //    键都小于被删除的节点和它的后继节点）
            x.left = t.left;
        }
        return x;
    }

    /* 删除最小节点 */
    TreeNode deleteMin(TreeNode x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        return x;
    }

    /* 找到最小节点 */
    TreeNode min(TreeNode x) {
        // 找到最左端的节点，即最小节点
        if (x.left == null) {
            return x;
        }
        return min(x.left);
    }
}
