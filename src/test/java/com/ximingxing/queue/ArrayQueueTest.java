package com.ximingxing.queue;

import org.junit.Test;

/**
 * Description:
 * Created By xxm
 */
public class ArrayQueueTest {

    @Test
    public void arrayQueueMethodTest() {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
        }
        System.out.println(queue.getSize());
        System.out.println(queue.toString());

        queue.dequeue();
        System.out.println(queue.toString());

        System.out.println(queue.getFront());

        System.out.println(queue.isEmpty());
    }
}