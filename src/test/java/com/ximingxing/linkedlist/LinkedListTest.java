package com.ximingxing.linkedlist;

import org.junit.Test;

/**
 * Description:
 * Created By xxm
 */
public class LinkedListTest {

    @Test
    public void linkedListMethodTest() {
        LinkedList<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

//        linkedList.add(2, 666);
//        System.out.println(linkedList);
//
//        linkedList.addLast(666);
//        System.out.println(linkedList);
//
//        System.out.println(linkedList.contains(666));
//
//        linkedList.set(0, 999);
//        System.out.println(linkedList);
//
//        System.out.println(linkedList.getSize());
//
//        linkedList.remove(0);
//        linkedList.remove(linkedList.getSize() - 1);
//        System.out.println(linkedList);
//        System.out.println(linkedList.getSize());
//
//        System.out.println(linkedList.getLast());
//        System.out.println(linkedList.removeLast());

        for (int i = 0; i < 5; i++) {
            linkedList.removeElement(i);
            System.out.println(linkedList);
        }
    }

}