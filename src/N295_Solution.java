import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @author 文进
 * @version 1.0
 * 295.数据流的中位数
 */
public class N295_Solution {
    public static void main(String[] args) {
        MedianFinder mF = new MedianFinder();
        mF.addNum(1);
        mF.addNum(2);
        System.out.println(mF.findMedian());
    }
}

/*
方法：优先队列，维护两个优先队列，一个小顶堆，一个大顶堆
时间复杂度：addNum: O(logn)
          findNum: O(1)
空间复杂度：O(n)
 */
class MedianFinder {
    PriorityQueue<Integer> large; // 小顶堆，其中的元素是整个列表中大的那部分
    PriorityQueue<Integer> small; // 大顶堆，其中的元素是整个列表中小的那部分
    public MedianFinder() {
        // 小顶堆
        large = new PriorityQueue<>();
        // 大顶堆
        small = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {
        if (small.size() >= large.size()) {
            small.offer(num);
            large.offer(small.poll());
        } else {
            large.offer(num);
            small.offer(large.poll());
        }
    }

    public double findMedian() {
        // 如果元素不一样多，多的那个堆的堆顶元素就是中位数
        if (large.size() < small.size()) {
            return small.peek();
        } else if (large.size() > small.size()) {
            return large.peek();
        }
        // 如果元素一样多，两个堆堆顶元素的平均数是中位数
        // 这里为了防止精度损失，要除 2.0 而不是 2
        return (large.peek() + small.peek()) / 2.0;
    }
}


/*
使用 ArrayList + sort, 会超过时间限制
 */
class MedianFinder2 {
    ArrayList<Integer> list;
    int size = 0;
    public MedianFinder2() {
        list = new ArrayList<>();
    }

    public void addNum(int num) {
        list.add(num);
        size++;
        list.sort((a, b) -> a - b);
    }

    public double findMedian() {
        int index = size / 2;
        return size % 2 == 0 ? (double) (list.get(index - 1) + list.get(index)) / 2 : (double) list.get(index);
    }
}