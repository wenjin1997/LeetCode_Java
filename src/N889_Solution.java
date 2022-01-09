/**
 * @author 文进
 * @version 1.0
 * 889.根据前序和后序遍历构造二叉树
 */
public class N889_Solution {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return construct(preorder, 0, preorder.length - 1,
                postorder, 0, postorder.length - 1);
    }

    TreeNode construct(int[] preorder, int preStart, int preEnd,
                       int[] postorder, int postStart, int postEnd) {
        // base case
        if (preStart > preEnd) {
            return null;
        }
        // 特别注意这种情况，容易忘记考虑
        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }

        int rootVal = preorder[preStart];
        // 后序遍历数组中左子树末端的索引
        int leftEndIndex = -1;
        for (int i = postStart; i < postEnd; i++) {
            if (postorder[i] == preorder[preStart + 1]) {
                leftEndIndex = i;
            }
        }
        // 创建根结点
        TreeNode root = new TreeNode(rootVal);

        // 递归调用
        int leftSize = leftEndIndex - postStart + 1;
        root.left = construct(preorder, preStart + 1, preStart + leftSize,
                postorder, postStart, leftEndIndex);
        root.right = construct(preorder, preStart + leftSize + 1, preEnd,
                postorder, leftEndIndex + 1, postEnd - 1);

        return root;
    }
}
