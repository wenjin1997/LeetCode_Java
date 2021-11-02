package question_231_240;

import edu.princeton.cs.algs4.In;

import java.util.Stack;

/**
 * @author 文进
 * @version 1.0
 * 232.用栈实现队列
 *
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
public class MyQueue {
    // 使用两个栈实现队列
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        while (!stack1.empty()) { // 先将stack1中的元素依次放入到stack2中
            stack2.push(stack1.pop());
        }
        stack1.push(x); // 将x放入到stack1的栈底
        while (!stack2.empty()) { // 将stack2栈中的元素依次放入到stack1中
            stack1.push(stack2.pop());
        }
    }

    public int pop() {
        return stack1.pop();
    }

    public int peek() {
        return stack1.peek();
    }

    public boolean empty() {
        return stack1.empty();
    }
}
