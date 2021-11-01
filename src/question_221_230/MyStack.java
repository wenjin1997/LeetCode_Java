package question_221_230;

import edu.princeton.cs.algs4.In;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 文进
 * @version 1.0
 * 225.用队列实现栈
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
public class MyStack {
//    // 方法一：双队列法
//    private Queue<Integer> queue1;
//    private Queue<Integer> queue2;
//
//    public MyStack() {
//        queue1 = new LinkedList<Integer>();
//        queue2 = new LinkedList<Integer>();
//    }
//
//    public void push(int x) {
//        queue2.offer(x); // 将x放入队列2中
//        while (!queue1.isEmpty()){
//            queue2.offer(queue1.poll()); // 将队列1中的元素依次放入队列2中
//        }
//        // 交换queue1与queue2
//        Queue<Integer> temp = queue1;
//        queue1 = queue2;
//        queue2 = temp;
//    }
//
//    public int pop() {
//        return queue1.poll();
//    }
//
//    public int top() {
//        return queue1.peek();
//    }
//
//    public boolean empty() {
//        return queue1.isEmpty();
//    }


    // 单队列法
    Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<Integer>();
    }

    public void push(int x) {
        int n = queue.size(); // 获取原队列的长度
        queue.offer(x);
        for(int i = 0; i < n; i++) {
            queue.offer(queue.poll());
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
