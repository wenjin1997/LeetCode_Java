import java.util.PriorityQueue;

/**
 * @author 文进
 * @version 1.0
 * 378.有序矩阵中第K小的元素
 */
public class N378_Solution {
    public static void main(String[] args) {
        int[] n1 = {1, 5, 9};
        int[] n2 = {10, 11, 13};
        int[] n3 = {12, 13, 15};
        int[][] matrix = {n1, n2, n3};
        System.out.println(kthSmallest(matrix, 8));
    }
    /*
    方法一：优先队列
    时间复杂度：O(klogn)，k 在最坏情况下为n^2
    空间复杂度：O(n)
     */
    public static int kthSmallest(int[][] matrix, int k) {
        // pq中的元素存放的是矩阵的指标
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->
                matrix[a[0]][a[1]] - matrix[b[0]][b[1]]);
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{i,0});
        }

        while (k-- > 1 & !pq.isEmpty()) {
            int[] index = pq.poll();
            if (index[1] + 1 < n) {
                pq.offer(new int[] {index[0], index[1] + 1});
            }
        }
        int[] res = pq.poll();
        return matrix[res[0]][res[1]];
    }
}


/*
方法二：二分查找
时间复杂度：O(nlog(r-l))，二分查找进行次数为O(log(r-l))，每次操作时间复杂度O(n)
空间复杂度：O(1)
 */
class N378_Solution2 {
    public static void main(String[] args) {
        int[] n1 = {1, 5, 9};
        int[] n2 = {10, 11, 13};
        int[] n3 = {12, 13, 15};
        int[][] matrix = {n1, n2, n3};
        System.out.println(kthSmallest(matrix, 8));
    }

    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            // 说明矩阵中 <= mid 的数量比 k 大，说明第 k 小的数应该 <= mid
            if (check(matrix, mid, k, n)) {
                right = mid;
            } else { // 说明矩阵中 <= mid 的数量比 k 小，说明第 k 小的数应该 > mid
                left = mid + 1;
            }
        }
        return left;
    }

    public static boolean check(int[][] matrix, int mid, int k, int n) {
        int i = n - 1;
        int j = 0;
        int num = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                num += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return num >= k;
    }
}