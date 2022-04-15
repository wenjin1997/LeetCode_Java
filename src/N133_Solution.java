import java.util.*;

/**
 * @author 文进
 * @version 1.0
 * 133.克隆图
 */
public class N133_Solution {
    private HashMap<Node, Node> visited = new HashMap<>();
    // DFS方法
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        // 如果该节点已经访问过了，则直接从哈希表中取出对应的克隆节点返回
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // 克隆节点，注意到为了深拷贝我们不会克隆它的邻居列表
        Node cloneNode = new Node(node.val, new ArrayList<>());
        // 哈希表存储
        visited.put(node, cloneNode);

        // 遍历该节点的邻居并更新克隆节点的邻居列表
        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }
        return cloneNode;
    }

    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}

// 方法二：广度优先搜索
class N133_Solution2 {
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        HashMap<Node, Node> visited = new HashMap<>();
        Queue<Node> pq = new LinkedList<>();
        pq.offer(node);
        visited.put(node, new Node(node.val, new ArrayList<>()));

        // 广度优先搜索
        while (!pq.isEmpty()) {
            // 取出队列的头节点
            Node n = pq.remove(); // remove函数和poll函数的区别是如果队列为空，remove函数会抛出异常
            // 遍历该节点的邻居
            for (Node neighbor : n.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    // 如果没有被访问过，就克隆并存储到哈希表中
                    visited.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    // 将邻居节点加入队列中
                    pq.add(neighbor);
                }
                // 更新当前节点的邻居列表
                visited.get(n).neighbors.add(visited.get(neighbor));
            }
        }
        return visited.get(node);
    }

    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
