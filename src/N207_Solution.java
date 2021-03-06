import java.util.LinkedList;
import java.util.List;

/**
 * @author 文进
 * @version 1.0
 * 207.课程表
 */
class N207_Solution {
    // 记录一次递归堆栈中的节点
    boolean[] onPath;
    // 记录遍历过的节点，防止走回头路
    boolean[] visited;
    // 记录图中是否有环
    boolean hasCycle = false;
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            // 遍历图中的所有节点
            traverse(graph, i);
        }
        // 只要没有循环依赖可以完成所有课程
        return !hasCycle;
    }
    
    void traverse(List<Integer>[] graph, int s) {
        if (onPath[s]) {
            // 出现环
            hasCycle = true;
        }
        
        if (visited[s] || hasCycle) {
            // 如果已经找到了环，也不用再遍历了
            return;
        }
        // 前序代码位置
        visited[s] = true;
        onPath[s] = true;
        for (int t : graph[s]) {
            traverse(graph, t);
        }
        // 后序代码位置
        onPath[s] = false;
    }
    
    // 建图函数
    List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        // 图中共有 numCourses 个节点
        List<Integer>[] graph = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<Integer>();
        }
        for (int[] edge : prerequisites) {
            int from = edge[0], to = edge[1];
            // 添加一条从 from 指向 to 的有向边
            // 边的方向是 被依赖 关系
            graph[from].add(to);
        }
        return graph;
    }
}
