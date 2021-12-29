import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 文进
 * @version 1.0
 * 933.最近的请求次数
 */
public class N933_Solution {
}
class RecentCounter {
    // 用队列实现
    Queue<Integer> q;

    public RecentCounter() {
        q = new LinkedList();
    }

    public int ping(int t) {
        // 将收到时间t的ping加入到队列中
        q.add(t);
        // 将所有在时间t - 3000 之前的ping移出队列
        while (q.peek() < t - 3000)
            q.poll();
        return q.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
