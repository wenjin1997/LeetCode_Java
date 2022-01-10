import java.util.*;

/**
 * @author 文进
 * @version 1.0
 * 652.寻找重复的子树
 */
public class N652_Solution {
    // 记录二叉树的序列化结果及出现的次数
    HashMap<String, Integer> memo = new HashMap<>();
    // 记录List结果
    LinkedList<TreeNode> res = new LinkedList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }

    /* 遍历二叉树，比较序列化结果，看是否有重复子树 */
    String traverse(TreeNode root) {
        if (root == null) {
            return "#";
        }
        // 递归遍历
        String left = traverse(root.left);
        String right = traverse(root.right);

        String subTree = left + "," + right + "," + root.val;
        int freq = memo.getOrDefault(subTree, 0);
        // 保证结果中不会出现重复的结果
        if (freq == 1) {
            res.add(root);
        }
        memo.put(subTree, freq + 1);
        return subTree;
    }
}
