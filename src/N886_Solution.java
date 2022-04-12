import java.util.LinkedList;
import java.util.List;

/**
 * @author 文进
 * @version 1.0
 * 886.可能的二分法
 */
public class N886_Solution {
    boolean ok = true;
    boolean[] visited;
    boolean[] color;

    public boolean possibleBipartition(int n, int[][] dislikes) {
        visited = new boolean[n + 1];
        color = new boolean[n + 1];
        List<Integer>[] graph = buildGraph(n, dislikes);
        for (int i = 1; i <= n; i++) {
            traverse(graph, i);
        }
        return ok;
    }

    // DFS
    void traverse(List<Integer>[] graph, int k) {
        if (!ok) return;
        visited[k] = true;

        for (int v : graph[k]) {
            if (!visited[v]) {
                color[v] = !color[k];
                traverse(graph, v);
            } else {
                if (color[v] == color[k]) {
                    ok = false;
                }
            }
        }
    }

    List<Integer>[] buildGraph(int n, int[][] dislikes) {
        // 图节点编号为 1,...,n
        List<Integer>[] graph = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] edge : dislikes) {
            int from = edge[1], to = edge[0];
            // 无向图相当于双向图
            graph[from].add(to);
            graph[to].add(from);
        }
        return graph;
    }
}
