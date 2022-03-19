import java.util.Arrays;

/**
 * @author 文进
 * @version 1.0
 * 179.最大数
 */
public class N179_Solution {
    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};
        N179_Solution s = new N179_Solution();
        System.out.println(s.largestNumber(nums));
    }
    /*
    方法：贪心法
     */
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] ss = new String[n];
        for (int i = 0; i < n; i++) {
            ss[i] = "" + nums[i];
        }
        Arrays.sort(ss, (a, b) -> {
            String sa = a + b, sb = b + a;
            return sb.compareTo(sa);
        });

        StringBuilder sb = new StringBuilder();
        for (String s : ss) sb.append(s);
        int len = sb.length();
        // 去除前导0
        int k = 0;
        while (k < len - 1 && sb.charAt(k) == '0') k++;
        return sb.substring(k);
    }
}
