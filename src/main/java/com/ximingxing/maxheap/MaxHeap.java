package com.ximingxing.maxheap;

import com.ximingxing.array.Array;

/**
 * Description: MaxHeap implement by array.
 * Created By xxm
 */
public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    public int getSize() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * @return the index of its parent node.
     */
    private int parent(int index) {
        if (index == 0)
            throw new IllegalArgumentException("index==0 doesn't has parent node");
        return (index - 1) / 2;
    }

    /**
     * @return the index of its left child node.
     */
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    /**
     * @return the index of its right child node.
     */
    private int rightChild(int index) {
        return index * 2 + 2;
    }
}
