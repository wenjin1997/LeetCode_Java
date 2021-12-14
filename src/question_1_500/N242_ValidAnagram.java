package question_1_500;

import java.util.Arrays;

/**
 * @author 文进
 * @version 1.0
 * 242.有效的字母异位词
 * 方法一：排序
 * 方法二：哈希表
 */
public class N242_ValidAnagram {
}

// 方法一：排序
class N242Solution1 {
    public boolean isAnagram(String s, String t) {
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        // return str1.length == str2.length ? Arrays.equals(str1, str2) : false;
        return str1.length == str2.length && Arrays.equals(str1, str2);
    }
}

// 方法二：哈希表
class N242Solution2 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        // 维护哈希表
        int[] table = new int[26];

        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            if (--table[t.charAt(i) - 'a'] < 0) return false;
        }
        return true;
    }
}
