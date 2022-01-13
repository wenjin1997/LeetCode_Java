/**
 * @author 文进
 * @version 1.0
 * 96.不同的二叉搜索树
 */
public class N96_Solution {
    public static void main(String[] args) {
        N96_Solution1 s = new N96_Solution1();
        System.out.println(s.numTrees(3));
    }
}

/**
 * 该方法利用备忘录，解决方法2时间
 * 复杂度过高的问题
 */
class N96_Solution1 {
    int[][] memo;  // 备忘录

    public int numTrees(int n) {
        // 对memo进行初始化
        memo = new int[n + 1][n + 1];
        // 计算闭区间[1,n]之间的BST总数
        return count(1, n);
    }

    /**
     * 计算[lo,...,hi]之间二叉搜索树的个数
     **/
    int count(int lo, int hi) {
        // 说明树为空，返回1
        if (lo > hi) {
            return 1;
        }

        if (memo[lo][hi] != 0) {
            return memo[lo][hi];
        }

        int res = 0;
        for (int mid = lo; mid <= hi; mid++) {
            // mid的值作为根结点root
            int left = count(lo, mid - 1);
            int right = count(mid + 1, hi);
            // 左右子树的个数的乘积是BST的总数
            res += left * right;
        }
        // 将结果存入memo备忘录中
        memo[lo][hi] = res;

        return res;
    }

}

/**
 * 该方法会超出时间限制
 */
class N96_Solution2 {
    public int numTrees(int n) {
        // 计算闭区间[1,n]之间的BST总数
        return count(1, n);
    }

    /**
     * 计算[lo,...,hi]之间二叉搜索树的个数
     **/
    int count(int lo, int hi) {
        // 说明树为空，返回1
        if (lo > hi) {
            return 1;
        }

        int res = 0;
        for (int i = lo; i <= hi; i++) {
            // i的值作为根结点root
            int left = count(lo, i - 1);
            int right = count(i + 1, hi);
            // 左右子树的个数的乘积是BST的总数
            res += left * right;
        }
        return res;
    }
}
