/**
 * Description:
 * <p>
 * 实现一: 仅保存front用来标记队列头部
 * 通过 `tail = (front + size - 1) mod capacity` 找到队尾
 * <p>
 * Created By xxm
 */
public class MyCircularQueue {

    private int front; // 指向队头
    private int size; // 当前队列元素个数
    private int capacity; // 队列容量
    private int[] q;

    public MyCircularQueue(int k) {
        this.size = 0;
        this.front = 0;
        this.q = new int[k];
        this.capacity = q.length;
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;
        ++size;
        // 从队尾入队, 计算tail
        int tail = (front + size - 1) % capacity;
        q[tail] = value;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        --size;
        // 计算下一个front的值
        front = (front + 1) % capacity;
        return true;
    }

    public int Front() {
        return isEmpty() ? -1 : q[front];
    }

    public int Rear() {
        return isEmpty() ? -1 : q[(front + size - 1) % capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return this.size == capacity;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
