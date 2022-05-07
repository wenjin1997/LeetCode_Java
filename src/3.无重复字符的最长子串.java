/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    // 滑动窗口
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int left = 0, right = 0;
        int length = 1;
        Set<Character> set = new HashSet<>();
        while (left <= right && right < s.length()) {
            while (right < s.length() && !set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
            }
            // System.out.println("left " + left + " right " + right);
            length = Math.max(length, right - left);
            set.remove(s.charAt(left));
            left++;  
        }
        return length;
    }
}
// @lc code=end

