/**
 * @author 文进
 * @version 1.0
 * 654.最大二叉树
 */
public class N654_Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    /* 将nums[lo,...,hi]构造成最大二叉树 */
    TreeNode build(int[] nums, int lo, int hi) {
        if (lo > hi) return null;

        // 首先找到nums[lo,...,hi]中的最大值
        int maxVal = Integer.MIN_VALUE;
        int index = -1; // 记录最大值的下标
        for (int i = lo; i <= hi; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                index = i;
            }
        }
        // 根结点为最大值
        TreeNode root = new TreeNode(maxVal);

        // 递归构造最大右子树和最大左子树
        root.left = build(nums, lo, index - 1);
        root.right = build(nums, index + 1, hi);

        return root;
    }
}
