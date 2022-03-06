package weeklyContent;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 文进
 * @version 1.0
 * 第283周赛：6016.Excel表中某个范围内的单元格
 */
public class N6016_Solution {
    public static void main(String[] args) {
        String s = "K1:L2";
        N6016_Solution solution = new N6016_Solution();
        System.out.println(solution.cellsInRange(s));
    }
    public List<String> cellsInRange(String s) {
        char start = s.charAt(0);
        int startNum = s.charAt(1) - '0';
        char end = s.charAt(3);
        int endNum = s.charAt(4) - '0';

        List<String> res = new ArrayList<>();

        for (char j = start; j <= end; j++) {
            for (int i = startNum; i <= endNum; i++) {
//                System.out.println(i);
                res.add(Character.toString(j) + Integer.toString(i));
            }
        }
        return res;
    }
}
