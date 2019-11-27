package datastructure.array;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Description: array
 * Created By xxm
 */
public class Array<E> implements Iterable<E> {

    private E[] data;
    private int size; // index

    /**
     * one-param constructor.
     *
     * @param capacity the capacity of array
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * default constructor.
     * default capacity : 10
     */
    public Array() {
        this(10);
    }

    public Array(E[] arr) {
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        size = arr.length;
    }

    /**
     * get capacity.
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * get the current number of array.
     */
    public int getSize() {
        return size;
    }

    /**
     * Sentenced to empty.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Add an element at the end of the array.
     *
     * @param e the element
     */
    public void addLast(E e) {
//        if (size == data.length) {
//            throw new IllegalArgumentException("addLast failed.array is full");
//        }
//
//        data[size] = e;
//        size++;
        add(size, e);
    }

    /**
     * Add an element at the first of the array.
     *
     * @param e the element
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * Add an element to the array's specified location.
     *
     * @param index the specified location
     * @param e     the element
     */
    public void add(int index, E e) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("addLast failed.Require index >= 0 and index <= size");
        }
        if (size == data.length) {
            resize(2 * data.length);
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        data[index] = e;
        size++;
    }

    /**
     * Get an element from array's specified location.
     *
     * @param index the specified location
     * @return the element
     */
    public E get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("get failed.Index out of bounds");
        }

        return data[index];
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    /**
     * Set an element from array's specified location.
     *
     * @param index the specified location
     * @return the element
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("set failed.Index out of bounds");
        }
        data[index] = e;
    }

    /**
     * Test array contain the element or not
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Find an element from array's specified location.
     *
     * @param e element
     * @return return index when found,-1 when not found
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Remove an element from array's specified location.
     *
     * @param index
     * @return removed element
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("remove failed.Index out of bounds");
        }
        E res = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;
        return res;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public boolean removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    /**
     * Resize the array.
     *
     * @param newCapacity new capacity
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    /**
     * Swap elements with subscripts I and j.
     *
     * @param i index
     * @param j index
     */
    public void swap(int i, int j) {
        if (i < 0 || i > size || j < 0 || j > size)
            throw new IllegalArgumentException("Index is Illegal!");

        E temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("array:size = %d,capacity = %d\n", size, data.length)).append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator();
    }

    @Override
    public void forEach(Consumer<? super E> action) {
    }

    private class ArrayIterator implements Iterator<E> {
        private int index;

        ArrayIterator() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public E next() {
            return data[index++];
        }
    }
}
