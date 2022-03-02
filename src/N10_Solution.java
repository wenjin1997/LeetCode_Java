import java.util.HashMap;

/**
 * @author 文进
 * @version 1.0
 * 10.正则表达式匹配
 */
public class N10_Solution {
    public static void main(String[] args) {
        String s = "aaa";
        String p = "a*a";
        N10_Solution n10_solution = new N10_Solution();
        System.out.println(n10_solution.isMatch(s, p));
    }
    public boolean isMatch(String s, String p) {
        // 指针 i, j 从索引 0 开始移动
        return dp(s, 0, p, 0);

    }
    HashMap<String, Boolean> memo = new HashMap<>(); // 备忘录
    /* 计算p[j..] 是否匹配 s[i..] */
    boolean dp(String s, int i, String p, int j) {
        int m = s.length(), n = p.length();
        // base case
        if (j == n) {
            return i == m;
        }
        if (i == m) {
            // 如果能匹配空串，一定是字符和 * 成对出现
            if ((n - j) % 2 == 1) {
                return false;
            }
            // 检查是否为 x*y*z* 这种形式
            for (; j + 1 < n; j = j + 2) {
                if (p.charAt(j + 1) != '*') {
                    return false;
                }
            }
            return true;
        }

        // 记录状态 (i, j)，消除重叠子问题
        String key = s.substring(i) + "," + p.substring(j);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        boolean res;

        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            // 匹配
            if (j < n - 1 && p.charAt(j + 1) == '*') {
                // 1.1 通配符匹配 0 次或多次
                //      dp(s, i, p, j + 2) 表示通配符匹配0次
                //      dp(s, i + 1, p, j) 表示通配符匹配多次
                res = dp(s, i, p, j + 2) || dp(s, i + 1, p, j);
            } else {
                // 1.2 常规匹配 1 次
                res = dp(s, i + 1, p, j + 1);
            }
        } else {
            // 不匹配
            if (j < n - 1 && p.charAt(j + 1) == '*') {
                // 2.1 通配符匹配 0 次
                res = dp(s, i, p, j + 2);
            } else {
                // 2.2 无法继续匹配，因为没有通配符
                res = false;
            }
        }
        // 将当前结果记入备忘录
        memo.put(key, res);

        return res;
    }
}
