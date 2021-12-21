import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author 文进
 * @version 1.0
 * 438.找到字符串中所有字母异位词
 */
public class N438_FindAllAnagramsInAString {
}

class N438_Solution {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        int sLen = s.length();
        int pLen = p.length();

        for (int i = 0; i < pLen; i++) {
            char temp = p.charAt(i);
            need.put(temp, need.getOrDefault(temp, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;
        ArrayList<Integer> res = new ArrayList<>();
        while (right < sLen) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(window.get(c))) {
                    valid++;
                }
            }
            // 判断左侧窗口何时收缩
            while (right - left >= pLen) {
                // 判断是否是异位词子串
                if (valid == need.size()) {
                    res.add(left);
                }
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (need.get(d).equals(window.get(d))) {
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        return res;
    }
}
