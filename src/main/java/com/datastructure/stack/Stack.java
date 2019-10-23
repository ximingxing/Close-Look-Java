package com.datastructure.stack;

/**
 * Description: Stack interface
 * Created By xxm
 */
public interface Stack<E> {

    void push(E e);

    E pop();

    E peek();

    int getSize();

    boolean isEmpty();
}
