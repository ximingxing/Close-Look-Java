import java.util.LinkedList;
import java.util.Queue;

/**
 * Description:
 * <p>
 * 使用一个队列模拟堆栈
 * 思路: push时, 将需要push的元素先入队，让队列中原有的元素依次出队并入队.
 * <p>
 * Created By xxm
 */
public class MyStack2 {

    private Queue<Integer> q;

    /**
     * Initialize your data structure here.
     */
    public MyStack2() {
        q = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        q.add(x);

        int n = q.size() - 1;
        for (int i = 0; i < n; i++) {
            q.add(q.poll());
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return q.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        int top = pop();
        push(top);
        return top;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return q.size() == 0;
    }
}


/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
