package question_151_160;

/**
 * @author 文进
 * @version 1.0
 * 155.最小栈
 * 关键点：在Node结点添加一个属性最小值
 *
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
class MinStack {
    private Node first;  // 栈顶

    private class Node { // 定义了结点的嵌套类
        int item;
        int minNum = item; // 表示栈中到该结点为止，栈中所有元素中的最小值
        Node next;
    }

    public MinStack() {

    }

    public void push(int val) { // 向栈顶添加元素
        Node oldfirst = first;
        first = new Node();
        first.item = val;
        if(oldfirst == null){
            first.minNum = val;
        } else{
            first.minNum = Math.min(val, oldfirst.minNum);
        }

        first.next = oldfirst;
    }

    public void pop() {
        // 从栈顶删除元素
        first = first.next;
    }

    public int top() {
        return first.item;
    }

    public int getMin() {
        return first.minNum;
    }
}