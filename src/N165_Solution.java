/**
 * @author 文进
 * @version 1.0
 * 165.比较版本号
 */
public class N165_Solution {
    public static void main(String[] args) {
        String version1 = "1.0.1";
        String version2 = "1";
        N165_Solution n165_solution = new N165_Solution();
        System.out.println(n165_solution.compareVersion(version1, version2));
    }
    /*
    方法：字符串分割，主要用String.split("\\.")，注意是"."，要用转义字符
    时间复杂度：O(n + m)，或 O(max(n, m)) 两者等价
    空间复杂度：O(n + m)
     */
    public int compareVersion(String version1, String version2) {
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");
        int i = 0, j = 0;
        while (i < split1.length && j < split2.length) {
            int a = Integer.parseInt(split1[i]);
            int b = Integer.parseInt(split2[j]);
            if (a < b) return -1;
            else if (a > b) return 1;
            else {
                i++;
                j++;
            }
        }
        while (i < split1.length) {
            int a = Integer.parseInt(split1[i]);
            if (a != 0) return 1;
            else i++;
        }
        while (j < split2.length) {
            int b = Integer.parseInt(split2[j]);
            if (b != 0) return -1;
            else j++;
        }
        return 0;
    }

    /*
    方法二：对方法一进行空间上的优化，双指针法
           在进行分割的同时进行比较。
    时间复杂度：O(n + m)
    空间复杂度：O(1)
     */
    public int compareVersion2(String version1, String version2) {
        int n = version1.length(), m = version2.length();
        int i = 0, j = 0;
        while (i < n || j < m) {
            int x = 0;
            for ( ; i < n && version1.charAt(i) != '.'; ++i) {
                x = x * 10 + version1.charAt(i) - '0';
            }
            ++i; // 跳过点号
            int y = 0;
            for (; j < m && version2.charAt(j) != '.'; ++j) {
                y = y * 10 + version2.charAt(j) - '0';
            }
            ++j; // 跳过点号
            if (x != y) {
                return x > y ? 1 : -1;
            }
        }
        return 0;
    }
}
