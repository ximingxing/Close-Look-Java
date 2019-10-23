package com.datastructure.queue;

import org.junit.Test;

/**
 * Description:
 * Created By xxm
 */
public class LinkedListQueueTest {

    @Test
    public void linkedListQueueMethodTest() {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        System.out.println(queue);

        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        System.out.println(queue);

        for (int i = 0; i < 5; i++) {
            queue.dequeue();
        }
        System.out.println(queue);

    }
}