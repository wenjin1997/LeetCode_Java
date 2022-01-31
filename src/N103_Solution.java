import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author 文进
 * @version 1.0
 * 103.二叉树的锯齿形层序遍历
 */
public class N103_Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>(); // 记录结果
        if (root == null) { // 如果根结点为空，直接返回
            return res;
        }

        // 借助数据结构——队列，其中存放节点
        Queue<TreeNode> q = new LinkedList<>();
        boolean RightToLeft = true; // 控制左右
        q.offer(root);
        // while循环控制从上到下循环
        while (!q.isEmpty()) {
            LinkedList<Integer> level = new LinkedList<>(); // 每一层的数组
            int sz = q.size();
            // for循环控制左右遍历
            for (int i = 0; i < sz; i++) {
                TreeNode curr = q.poll();

                // **重点**：将level设为LinkedList，
                //          通过addLast和addFirst方法来控制遍历的方向
                if (RightToLeft) { // 第一次从右至左遍历
                    level.addLast(curr.val);
                } else { // 从左至右遍历
                    level.addFirst(curr.val);
                }

                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
            // 更改方向
            RightToLeft = !RightToLeft;
            res.add(level);
        }
        return res;
    }
}
