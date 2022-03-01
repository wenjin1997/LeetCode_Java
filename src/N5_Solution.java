/**
 * @author 文进
 * @version 1.0
 * 5.最长回文子串
 * 时间复杂度：O(N^2)
 * 空间复杂度:O(1)
 */
public class N5_Solution {
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            // 以 s[i] 为中心的最长回文子串
            String s1 = palindrome(s, i, i);
            // 以 s[i] 和 s[i + 1] 为中心的最长回文子串
            String s2 = palindrome(s, i, i + 1);
            // res = longest(res, s1, s2)
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    /* 寻找最长回文串 */
    String palindrome(String s, int l, int r) {
        // 防止索引越界
        while (l >= 0 && r < s.length()
                && s.charAt(l) == s.charAt(r)) {
            // 向两边展开
            l--;
            r++;
        }
        // 返回以 s[l] 和 s[r] 为中心的最长回文串
        // 返回 s[l + 1, r) 字符串，不包括r
        return s.substring(l + 1, r);
    }
}
