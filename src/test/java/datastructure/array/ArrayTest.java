package datastructure.array;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

/**
 * Description:
 * Created By xxm
 */
public class ArrayTest {

    @Test
    public void getCapacity() {
        Array<Integer> array = new Array<>();
        System.out.println(array.getCapacity());
    }

    @Test
    public void getSize() {
    }

    @Test
    public void isEmpty() {
    }

    @Test
    public void addLast() {
    }

    @Test
    public void addFirst() {
    }

    @Test
    public void add() {
    }

    @Test
    public void get() {
    }

    @Test
    public void getFirst() {
    }

    @Test
    public void getLast() {
    }

    @Test
    public void set() {
    }

    @Test
    public void contains() {
    }

    @Test
    public void find() {
    }

    @Test
    public void remove() {
    }

    @Test
    public void removeFirst() {
    }

    @Test
    public void removeLast() {
    }

    @Test
    public void removeElement() {
    }

    @Test
    public void iterator() {
        Integer[] arr = {1, 2, 3, 4, 5};
        Array<Integer> array = new Array<>(arr);

        Iterator<Integer> iterator = array.iterator();
        while (iterator.hasNext()) System.out.println(iterator.next());
    }
}