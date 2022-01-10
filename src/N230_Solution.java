/**
 * @author 文进
 * @version 1.0
 * 230.二叉搜索树中第K小的元素
 * 思路：利用中序遍历
 * 二叉搜索树的中序遍历结果是二叉搜索树的升序结果
 */
public class N230_Solution {
    int res = 0;    // 记录结果
    int rank = 0;   // 记录当前节点是第几小的数

    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return res;
    }

    void traverse(TreeNode root, int k) {
        // base case
        if (root == null) {
            return;
        }
        // 递归遍历
        traverse(root.left, k);
        // 中序遍历位置
        rank++;
        if (rank == k) { // 找到第k小的数
            res = root.val;
            return;     // 这里找到后可以直接返回
        }
        traverse(root.right, k);
    }
}
