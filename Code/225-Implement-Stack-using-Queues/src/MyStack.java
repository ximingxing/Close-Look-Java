import java.util.LinkedList;
import java.util.Queue;

/**
 * Description:
 * <p>
 * 使用两个队列模拟堆栈
 * 思路: push元素时, 将该元素push到1号队列,
 * pop元素时, 让1号队列前n-1个元素进入2号队列, 1号队列中剩余的元素即为栈顶.
 * <p>
 * Created By xxm
 */
public class MyStack {
    // 使用一个数组存储两个队列
    private Queue<Integer>[] q;

    // 返回队列数组中非空的队列
    // 如果两个都非空, 返回 1 号队列.
    private int getInd() {
        return q[0].isEmpty() ? 1 : 0;
    }

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        q = new Queue[2];
        for (int i = 0; i < 2; i++) {
            q[i] = new LinkedList<>();
        }
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        // 向当前非空的那个队列中添加元素, 默认为 1 号队列
        q[getInd()].add(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        // 元素出队的时候,
        // 将1号队列中的前 n-1 个元素加入2号队列
        // 此时, 1号队列中剩余的最后一个元素即为栈顶.
        // 将这个元素pop出去即可 (模拟堆栈).
        final int ind = getInd();
        while (q[ind].size() > 1) {
            q[ind ^ 1].add(q[ind].poll());
        }
        return q[ind].poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        int r = pop();
        push(r);
        return r;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        // 两个队列中都没有元素,
        // 说明模拟的堆栈为空
        return q[0].isEmpty() && q[1].isEmpty();
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
