import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author 文进
 * @version 1.0
 * 1514.概率最大的路径
 */
public class N1514_Solution {
    // Dijkstra 算法
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<double[]>[] graph = buildGraph(n, edges, succProb);
        double[] distTo = new double[n];
        Arrays.fill(distTo, -1);
        distTo[start] = 1;
        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> {
            return Double.compare(b.distFromStart, a.distFromStart);
        });
        pq.offer(new State(start, 1));

        while (!pq.isEmpty()) {
            State curState = pq.poll();
            int cur = curState.index;
            double curDist = curState.distFromStart;
            if (cur == end) {
                return curDist;
            }
            if (distTo[cur] > curDist) {
                continue;
            }
            for (double[] next : graph[cur]) {
                int nextNode = (int)next[0];
                double nextDist = next[1] * curDist;
                if (distTo[nextNode] < nextDist) {
                    distTo[nextNode] = nextDist;
                    pq.offer(new State(nextNode, nextDist));
                }
            }
        }
        return 0.0;
    }

    List<double[]>[] buildGraph(int n, int[][] edges, double[] succProb) {
        List<double[]>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0], to = edges[i][1];
            graph[from].add(new double[] {to, succProb[i]});
            graph[to].add(new double[] {from, succProb[i]});
        }
        return graph;
    }

    class State {
        int index;
        double distFromStart;
        public State(int index, double distFromStart) {
            this.index = index;
            this.distFromStart = distFromStart;
        }
    }
}
