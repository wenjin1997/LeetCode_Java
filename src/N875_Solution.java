import java.util.Arrays;

/**
 * @author 文进
 * @version 1.0
 * 875.爱吃香蕉的珂珂
 * 思路：二分查找，取左边界
 */
public class N875_Solution {
    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        System.out.println(minEatingSpeed(piles, h));
    }
    public static int minEatingSpeed(int[] piles, int h) {
        // 用二分查找
        /* 先确定left和right，最小的速度为1，最大的速度为数组中的最大值*/
        int left = 1;
        /* 取数组的最大值：可以先用Arrays排序，再取数组中最后一个下标的数*/
        Arrays.sort(piles);
        int right = piles[piles.length - 1];
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int needH = 0;
            for (int i = 0; i < piles.length; i++) {
                /* 注意：如果余数为0，相除后不用再加一
                *       如果余数不为0，则需要加一。*/
                if (piles[i] % mid == 0) {
                    needH += piles[i] / mid;
                } else {
                    needH += piles[i] / mid + 1;
                }
            }
            /* Remark: 1.这里容易犯的错误是弄错条件的正反，也就是
            *          大于小于号的情况，可以理解题意，如果算出
            *          所需的时间小于h，那么说明速度还可以缩小，
            *          因此可以将right缩小。
            *          2.二分法采用取左边界的方法           */
            if (needH > h) {
                left = mid + 1;
            } else if (needH == h) {
                right = mid - 1;
            } else if (needH < h) {
                right = mid - 1;
            }
        }
        return left;
    }
}
