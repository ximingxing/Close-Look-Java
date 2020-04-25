package datastructure.queue;

import org.junit.Test;

/**
 * Description:
 * Created By xxm
 */
public class LoopQueueTest {

    @Test
    public void loopQueueMethodTest() {
        LoopQueue<Integer> queue = new LoopQueue<>();
        // enqueue
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        System.out.println(queue + " capacity: " + queue.getCapacity());
        // dequeue
        queue.dequeue();

        System.out.println(queue);

        // peek
        System.out.println(queue.getFront());

        // enqueue and expand the capacity
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i * 2);
        }
        System.out.println(queue + " capacity: " + queue.getCapacity());

        // dequeue and reduce the capacity
        for (int i = 0; i < 10; i++) {
            queue.dequeue();
        }
        System.out.println(queue + " capacity: " + queue.getCapacity());
    }

}