import java.util.Deque;
import java.util.Stack;

/**
 * Description:
 * Created By xxm
 */
public class MyQueue {
    private Stack<Integer> s;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        s = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        // new : 3
        // s   : 1, 2 <- top
        // temp: 2, 1 <- top
        // s   : 3
        // s   : 3, 2, 1 <- top

        // 将s中的元素压入一个临时堆栈中
        Stack<Integer> temp = new Stack<>();
        while (!s.isEmpty()) {
            temp.push(s.pop());
        }
        // 此时s为空;
        // 将元素x压入s.
        s.push(x);
        // 将临时堆栈中的元素重新压入s
        while (!temp.isEmpty()) {
            s.push(temp.pop());
        }
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        return s.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        return s.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return s.size() == 0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
