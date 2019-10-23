package datastructure.heap;

import datastructure.array.Array;

/**
 * Description: MaxHeap implement by array.
 * Created By xxm
 */
public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    /**
     * Heapify
     *
     * @param arr
     */
    public MaxHeap(E[] arr) {
        data = new Array<>(arr);
        for (int i = parent(arr.length - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

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

    /**
     * Add an element to MaxHeap.
     */
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int index) {
        // swap element if it bigger than its parent
        while (index > 0 && data.get(parent(index)).compareTo(data.get(index)) < 0) {
            data.swap(index, parent(index));
            index = parent(index);
        }
    }

    public E findMax() {
        if (data.getSize() == 0)
            throw new IllegalArgumentException("Heap is empty!");
        return data.get(0);
    }

    /**
     * Remove the biggest element of heap.
     */
    public E extractMax() {
        E max = findMax();

        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);

        return max;
    }

    private void siftDown(int index) {
        while (leftChild(index) < data.getSize()) {

            int j = leftChild(index);
            // compare index with its left and right
            if (j + 1 < data.getSize() &&  // its has right child
                    data.get(j + 1).compareTo(data.get(j)) > 0) // right child bigger than left one
                j = rightChild(index);

            // compare index with its biggest child
            if (data.get(index).compareTo(data.get(j)) > 0)
                break;

            data.swap(j, index);
            index = j;
        }
    }

    /**
     * Take the largest element in the heap and replace it with e
     *
     * @return e
     */
    public E replace(E e) {
        E ret = findMax();

        data.set(0, e);
        siftDown(0);

        return ret;
    }
}
