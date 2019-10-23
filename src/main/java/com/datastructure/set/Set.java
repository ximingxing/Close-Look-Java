package com.datastructure.set;

/**
 * Description: Set interface
 * Created By xxm
 */
public interface Set<E> {

    void add(E e);

    void remove(E e);

    boolean contains(E e);

    int getSize();

    boolean isEmpty();
}
