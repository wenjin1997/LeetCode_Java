/*
 * @lc app=leetcode.cn id=207 lang=java
 *
 * [207] 课程表
 */

// @lc code=start
class Solution {
    // 方法一：深度优先搜索
    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        onPath = new boolean[numCourses];
        visited = new boolean[numCourses];
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        for (int i = 0; i < numCourses; i++) {
            traverse(graph, i);
        }
        return !hasCycle;
    }

    boolean[] onPath;   // 记录路径
    boolean[] visited;  // 记录访问的节点
    boolean hasCycle;   // 图中是否有环
    // 回溯，深度优先搜索
    private void traverse(List<Integer>[] graph, int s) {
        if (onPath[s]) {
            hasCycle = true;
        }
        if (hasCycle || visited[s]) { // 已经找到环或者已经遍历过了
            return;
        }

        // 前序代码位置
        onPath[s] = true;
        visited[s] = true;
        for (int t : graph[s]) {
            traverse(graph, t);
        }
        // 后序代码位置
        onPath[s] = false;
    } 
    // 建图
    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] edge : prerequisites) {
            int from = edge[1], to = edge[0];
            // 修完 edge[1] 课程后才能修 edge[0]
            graph[from].add(to);
        }
        return graph;
    }

    // 方法二：广度优先搜索
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 建图
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        // 构建入度数组
        int[] indegree = new int[numCourses];
        for (int[] edge : prerequisites) {
            int from = edge[1], to = edge[0];
            // 节点 to 的入度加一
            indegree[to]++;
        }
        // 根据入度初始化队列
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                // 如果入度为0，则加入队列
                q.offer(i);
            }
        }
        int count = 0; // 记录遍历的节点的个数
        while (!q.isEmpty()) {
            // 弹出节点并将它指向的节点的入度减一
            int cur = q.poll();
            count++;
            for (int next : graph[cur]) {
                indegree[next]--;
                // 如果入度为0，则加入队列中
                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }
        // 如果所有节点都遍历过，则说明没有形成环
        return count == numCourses;
    }
    
}
// @lc code=end

