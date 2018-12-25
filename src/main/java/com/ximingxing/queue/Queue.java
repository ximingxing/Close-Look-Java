package com.ximingxing.queue;

/**
 * Description: Queue interface
 * Created By xxm
 */
public interface Queue<E> {

    void enqueue(E e);

    E dequeue();

    E getFront();

    int getSize();

    boolean isEmpty();
}
