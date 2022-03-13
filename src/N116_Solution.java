/**
 * @author 文进
 * @version 1.0
 * 116.填充每个节点的下一个右侧节点指针
 * 思路：递归法
 */
public class N116_Solution {
    // 主函数
    public Node connect(Node root) {
        if (root == null) return null;
        connectTwoNode(root.left, root.right);
        return root;
    }
    // 辅助函数
    void connectTwoNode(Node  node1, Node node2) {
        if (node1 == null || node2 == null) return;
        /**** 前序遍历位置 ****/
        // 将传入的两个节点连接
        node1.next = node2;

        // 连接相同父节点的两个子节点
        connectTwoNode(node1.left, node1.right);
        connectTwoNode(node2.left, node2.right);
        // 连接跨越父节点的两个子节点
        connectTwoNode(node1.right, node2.left);
    }
}

