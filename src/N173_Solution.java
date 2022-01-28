import java.util.Stack;

/**
 * @author 文进
 * @version 1.0
 * 173.二叉搜索树迭代器
 */
public class N173_Solution {
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
class BSTIterator {
    // 模拟递归栈
    private Stack<TreeNode> stk = new Stack<>();

    public BSTIterator(TreeNode root) {
        pushLeftBranch(root);
    }

    public int next() {
        TreeNode p = stk.pop();
        pushLeftBranch(p.right);
        return p.val;
    }

    public boolean hasNext() {
        return !stk.isEmpty();
    }

    // 左侧树枝遍历到底
    private void pushLeftBranch(TreeNode p) {
        while (p != null) {
            stk.push(p);
            p = p.left;
        }
    }
}


