package datastructure.queue;

/**
 * Description: LoopQueue
 * Created By xxm
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front; // point to first element in queue
    private int tail;  // point to last element'next space in queue
    private int size;

    public LoopQueue(int capacity) {
        // waste a space for judge queue full or not
        data = (E[]) new Object[capacity + 1];
    }

    public LoopQueue() {
        this(10);
    }

    @Override
    public void enqueue(E e) {
        // expand the capacity if queue is full
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {
        // judge empty
        if (this.isEmpty()) {
            throw new IllegalArgumentException("can`t dequeue from an empty Queue");
        }

        E ret = data[front];
        data[front] = null;
        // maintenance the front point
        front = (front + 1) % data.length;

        // reduce the capacity to save space
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    @Override
    public E getFront() {
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            // it`s convenient to index newData from zero,and data may have offset
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        // maintenance the front and tail points
        front = 0;
        tail = size;
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("LoopQueue :size = %d,capacity = %d\n", size, data.length)).append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }
}
