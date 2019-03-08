package com.ximingxing.tree;

/**
 * Description: Merger two element with user-defined method.
 * Created By xxm
 */
public interface Merger<E> {

    E merge(E a, E b);
}
