package 面试题17;


/**
 * @author 文进
 * @version 1.0
 * 面试题17.14.最小K个数
 */
public class N14_SmallestKLCCI {
    public static void main(String[] args) {
        int[] arr = {1,3,5,7,2,4,6,8};
        int k = 4;
        int[] ans = new int[k];
        Solution solution = new Solution();
        ans = solution.smallestK(arr, k);
        for (int i = 0; i < k; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}

class Solution {
    public int[] smallestK(int[] arr, int k) {
        MaxPQ pq = new MaxPQ(k + 1);
        int[] ans = new int[k];
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            pq.insert(arr[i]);
            if (pq.size() > k) {
                pq.delMax();
            }
        }
        for (int i = 0; i < k && !pq.isEmpty(); i++) {
            ans[i] = pq.delMax();
        }
        return ans;
    }
}

class MaxPQ {
    private int[] pq;       // 基于堆的完全按二叉树
    private int N = 0;      // 存储于pq[1..N]中，pq[0]没有使用

    public MaxPQ(int maxN) {
        pq = new int[maxN + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(int v) {
        pq[++N] = v;
        swim(N);
    }

    public int delMax() {
        int max = pq[1];          // 从根结点得到最大元素
        exch(1, N--);           // 将其和最后一个结点交换
//        pq[N + 1] = null;         // 防止对象游离
        sink(1);                // 恢复堆的有序性
        return max;
    }

    private boolean less(int i, int j) {
        return pq[i] < pq[j];
    }

    private void exch(int i, int j) {
        int t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    // 由下至上的堆有序化（上浮）的实现
    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    // 由上至下的堆有序化（下沉）的实现
    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) j++;
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }
}