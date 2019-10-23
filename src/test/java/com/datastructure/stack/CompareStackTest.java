package com.datastructure.stack;

import java.util.Random;

/**
 * Description:
 * Created By xxm
 */
public class CompareStackTest {


    public static double testStack(Stack<Integer> stack, int opCount) {
        Random random = new Random();

        long startTime = System.nanoTime();

        // enqueue and dequeue
        for (int i = 0; i < opCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        int opCount = 100000;

        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        System.out.println("ArrayStack time: " + testStack(arrayStack, opCount) + "s");

        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        System.out.println("LinkedListStack time: " + testStack(linkedListStack, opCount) + "s");
    }
}
