package datastructure.queue;

import org.junit.Test;

import java.util.Random;

/**
 * Description: compare ArrayQueue performance with LoopQueue
 * Created By xxm
 */
public class CompareQueueTest {

    public static double testQueue(Queue<Integer> queue, int opCount) {
        Random random = new Random();

        long startTime = System.nanoTime();

        // enqueue and dequeue
        for (int i = 0; i < opCount; i++) {
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            queue.dequeue();
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    @Test
    public void arrayAndLoopAndLinkedListQueueCompare() {

        int opCount = 100000;

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        System.out.println("ArrayQueue time: " + testQueue(arrayQueue, opCount) + "s");

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        System.out.println("LoopQueue time: " + testQueue(loopQueue, opCount) + "s");

        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        System.out.println("LinkedListQueue time: " + testQueue(linkedListQueue, opCount) + "s");
    }

}
