/**
 * @author 文进
 * @version 1.0
 * 108.将有序数组转换为二叉搜索树
 */
public class N108_Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    // 将闭区间[left,right]中的元素构造二叉搜索树，返回根节点
    TreeNode build(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(nums, left, mid - 1);
        root.right = build(nums, mid + 1, right);
        return root;
    }
}
