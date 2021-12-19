import java.util.HashMap;

/**
 * @author 文进
 * @version 1.0
 * 706.最小覆盖子串
 * 思路：滑动窗口
 */
public class N76_MinimumWindowSubstring {
}

class N76_Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<>(); // 记录需要的字符串的频数
        HashMap<Character, Integer> window = new HashMap<>();
        int sLen = s.length();
        int tLen = t.length();
        /* 先更新need */
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int vaild = 0;
        // 记录最小覆盖子串的起始索引及长度
        int start = 0, len = Integer.MAX_VALUE; // 或者 len = sLen + 1;
        while (right < sLen) {
            // c是将移入窗口的字符
            char c = s.charAt(right);
            // 右移窗口
            right++;
            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    vaild++;
                }
            }

            // 判断左侧窗口是否要收缩
            while (vaild == need.size()) {
                // 在这里更新最小覆盖子串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // d 是将移出窗口的字符
                char d = s.charAt(left);
                // 左移窗口
                left++;
                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)) {
                    if (need.get(d).equals(window.get(d))) {
                        vaild--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        // 返回最小覆盖子串
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
