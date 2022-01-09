/**
 * @author 文进
 * @version 1.0
 * 106. 从中序与后序遍历序列构造二叉树
 */
public class N106_Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1);
    }
    TreeNode build(int[] inorder, int inStart, int inEnd,
                   int[] postorder, int postStart, int postEnd) {
        // base case
        if (inStart > inEnd) return null;

        // 根结点是postorder数组的最后一个元素
        int rootVal = postorder[postEnd];
        // 找到inorder数组中root.left的末尾索引 + 1
        int leftIndex = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                leftIndex = i;
                break;
            }
        }
        // 构造根结点
        TreeNode root = new TreeNode(rootVal);

        // 递归调用
        int leftSize = leftIndex - inStart;
        root.left = build(inorder, inStart, leftIndex - 1,
                postorder, postStart, postStart + leftSize - 1);
        root.right = build(inorder, leftIndex + 1, inEnd,
                postorder, postStart + leftSize, postEnd - 1);

        return root;
    }
}
