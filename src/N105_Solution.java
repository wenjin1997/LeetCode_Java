/**
 * @author 文进
 * @version 1.0
 * 105.从前序与中序遍历序列构造二叉树
 */
public class N105_Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);

    }

    TreeNode build(int[] preorder, int preStart, int preEnd,
                   int[] inorder, int inStart, int inEnd) {
        // base case
        if (preStart > preEnd) {
            return null;
        }

        // 根结点的值为preorder数组的第一个元素
        int rootVal = preorder[preStart];

        // 找到中序遍历数组中的根结点位置
        int index = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                index = i;
            }
        }

        // 构造根结点
        TreeNode root = new TreeNode(rootVal);

        // 递归调用，构造左子树和右子树
        int leftSize = index - inStart;
        root.left = build(preorder, preStart + 1, preStart + leftSize,
                inorder, inStart, index - 1);
        root.right = build(preorder, preStart + leftSize + 1, preEnd,
                inorder, index + 1, inEnd);

        return root;
    }
}
