class Solution {
    // 广度优先搜索
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        // 保证重建序列集的完整性，即重建序列中元素能是 {1,...,n}
        Set<Integer> set = new HashSet<>();
        for (List<Integer> list : seqs) {
            for (int ele : list) {
                set.add(ele);
            }
        }
        // 如果set中元素不够，返回 false
        if (set.size() != org.length) return false;
        // 如果元素不匹配，返回 false
        for (int i = 1; i <= org.length; i++) {
            if (!set.contains(i)) {
                return false;
            }
        }
        
        List<Integer>[] graph = buildGraph(org, seqs);

        // 初始化队列
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        
        int count = 0;
        int[] res = new int[org.length];
        while (!q.isEmpty()) {
            // 保证唯一性
            if (q.size() > 1) return false;
            
            int cur = q.poll();
            res[count] = cur; // 记录拓扑排序结果
            count++;
            int nextCount = 0;
            for (int next : graph[cur]) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    q.offer(next);
                    
                }
            }
        }
        
        // 出现环的情况
        if (count != org.length) return false;
        // 比较每一个元素
        for (int i = 0; i < org.length; i++) {
            if (org[i] != res[i]) return false;
        }
        
        return true;
    }
    
    // 建图
    int[] indegree; // 入度数组
    private List<Integer>[] buildGraph(int[] org, List<List<Integer>> seqs) {
        List<Integer>[] graph = new LinkedList[org.length + 1];
        indegree = new int[org.length + 1];
        for (int i = 0; i <= org.length; i++) {
            graph[i] = new LinkedList<>();
        }
        
        for (List<Integer> ele : seqs) {
            if (ele.size() < 2) continue;
            for (int i = 1; i < ele.size(); i++) {
                int from = ele.get(i - 1), to = ele.get(i);
                graph[from].add(to);
                indegree[to]++;
            }
        }
        return graph;
    }
}