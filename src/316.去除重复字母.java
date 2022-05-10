/*
 * @lc app=leetcode.cn id=316 lang=java
 *
 * [316] 去除重复字母
 */

// @lc code=start
class Solution {
    public String removeDuplicateLetters(String s) {
        Deque<Character> stack = new ArrayDeque<>(); // 栈
        // 记录栈中是否放入某个字符
        boolean[] inStack = new boolean[26];
        // 记录每个字符出现的次数
        int[] count = new int[26];
        // 初始化 count 数组
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        for (char c : s.toCharArray()) {
            // 遍历过就将 count 减一
            count[c - 'a']--;
            // 如果栈中已经有字符 c 了，就不再加入
            if (inStack[c - 'a']) continue;
            
            // 如果栈顶中的元素在后面会出现并且字典排序比当前字符大，
            // 就出栈
            while (!stack.isEmpty() && stack.peek() > c) {
                if (count[stack.peek() - 'a'] == 0) {
                    break;
                }
                inStack[stack.pop() - 'a'] = false;
            }
            stack.push(c);
            inStack[c - 'a'] = true;
        }

        // 将栈中的元素逆序，输出结果
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.poll());
        }
        return sb.reverse().toString();
    }
}
// @lc code=end

