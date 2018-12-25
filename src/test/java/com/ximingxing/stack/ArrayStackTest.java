package com.ximingxing.stack;

import org.junit.Test;

/**
 * Description:
 * Created By xxm
 */
public class ArrayStackTest {

    ArrayStack<Integer> stack = new ArrayStack<>();

    @Test
    public void arrayStackMethodTest() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.toString());

        System.out.println(stack.peek());

        stack.pop();
        System.out.println(stack.toString());
    }

}