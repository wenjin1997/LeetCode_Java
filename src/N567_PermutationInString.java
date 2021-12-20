import java.util.HashMap;

/**
 * @author 文进
 * @version 1.0
 * 567.字符串的排列
 * 思路：用滑动窗口解决
 */
public class N567_PermutationInString {
    public static void main(String[] args) {
        String s1 = "abcdxabcde";
        String s2 = "abcdeabcdx";
        N567_Solution solution = new N567_Solution();
        System.out.println(solution.checkInclusion(s1, s2));
    }
}

class N567_Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        int s1Len = s1.length();
        int s2Len = s2.length();

        for (int i = 0; i < s1Len; i++) {
            char c = s1.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;
        while (right < s2Len) {
            char c = s2.charAt(right);
            right++;
            // 进行一系列更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            // 对左侧窗口进行收缩
            while (right - left >= s1Len) {
                char d = s2.charAt(left);
                left++;
                // 进行子串是否是全排列的判断
                if (valid == need.size()) {
                    return true;
                }
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        // 未找到符合条件的子串
        return false;
    }
}
