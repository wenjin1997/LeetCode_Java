import java.util.HashMap;

/**
 * @author 文进
 * @version 1.0
 * 3.无重复字符的最长子串
 * 思路：滑动窗口
 */
public class N3_LongestSubstringWithoutRepeatingCharacters {
}
class N3_Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> window = new HashMap<>();
        int sLen = s.length();
        int left = 0, right = 0;
        int valid = 0;
        int res = 0;
        while (right < sLen) {
            char c = s.charAt(right);
            right++;
            // 进行一系列的更新
            window.put(c, window.getOrDefault(c, 0) + 1);
            // 判断左侧窗口是否收缩
            while (window.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                // 进行窗口内数据的一系列更新
                window.put(d, window.getOrDefault(d, 0) - 1);
            }
            if (right - left > res) {
                res = right - left;
            }
        }
        return res;
    }
}
