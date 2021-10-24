package question_11_20;

import java.util.Stack;

/**
 * @author 文进
 * @version 1.0
 * 20.有效的括号
 */
class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> parent = new Stack<>(); // 左括号栈

        while(s.length() > 0){
            char character = s.charAt(0);
            if(character == '(' || character == '['  || character == '{' ){ // 左括号
                parent.push(character);
            }
            if(character == ')' || character == ']'  || character == '}'){ // 右括号
                if(parent.empty()){ // 如果栈中没有左括号，则返回false
                    return false;
                }
                char c = parent.pop(); // 取出左括号栈中的栈顶元素
                // 如果取出的左括号与右括号不匹配，返回false
                if(c == '('){
                    if(character != ')') return false;
                } else if(c == '[') {
                    if(character != ']') return false;
                } else if(c == '{') {
                    if(character != '}') return false;
                }
            }
            // 在字符串s中去掉第一个字符，从索引1后面开始截取字符串
            s = s.substring(1);
        }
        // 如果处理完完字符串中所有字符后，栈中还有元素，说明还有左括号没有匹配，返回false
        // 如果栈中没有元素，说明所有括号已经匹配完成，返回true
        return parent.empty();
    }

    public static void main(String[] args) {
        String s = "()[}";
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid(s));
    }
}
