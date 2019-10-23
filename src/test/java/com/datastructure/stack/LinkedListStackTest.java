package com.datastructure.stack;

import org.junit.Test;

/**
 * Description:
 * Created By xxm
 */
public class LinkedListStackTest {

    @Test
    public void LinkedListStackMethodTest() {
        LinkedListStack<Integer> stack = new LinkedListStack<>();

        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        System.out.println(stack);

        System.out.println(stack.pop());
        System.out.println(stack);

        System.out.println(stack.peek());
    }

}