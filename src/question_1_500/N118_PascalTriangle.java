package question_1_500;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 文进
 * @version 1.0
 * 118.杨辉三角
 */
public class N118_PascalTriangle {
}
class N118_Solution1 {
    public List<List<Integer>> generate(int numRows) {
        // 数学方法 杨辉三角形表示的是二项式展开的系数
        // C(n,i) = C(n-1, i) + C(n-1, i-1)
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(result.get(i - 1).get(j) + result.get(i - 1).get(j - 1));
                }
            }
            result.add(row);
        }
        return result;
    }
}
