/**
 * Description:
 * <p>
 * 实现二: 保存指向队尾元素的下标
 * 通过 `front = (tail - size + 1 + capacity) mod capacity` 找到队首
 * <p>
 * Created By xxm
 */
public class MyCircularQueue2 {

    private int tail; // 指向队头
    private int size; // 当前队列元素个数
    private int capacity; // 队列容量
    private int[] q;

    public MyCircularQueue2(int k) {
        this.size = 0;
        this.tail = k - 1;
        this.q = new int[k];
        this.capacity = q.length;
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;
        ++size;
        // 从队尾入队, 计算tail
        // 注意: 这里需要更新tail
        tail = (tail + 1) % capacity;
        q[tail] = value;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        // 从队首出队, 由于我们没有显式标记队首
        // 所以仅需要将size--
        --size;
        return true;
    }

    public int Front() {
        return isEmpty() ? -1 : q[(tail - size + 1 + capacity) % capacity];
    }

    public int Rear() {
        return isEmpty() ? -1 : q[tail];
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
