package com.datastructure.heap;

import org.junit.Test;

import java.util.Random;

/**
 * Description:
 * Created By xxm
 */
public class MaxHeapTest {

    @Test
    public void MaxHeapTestOne() {
        MaxHeap<Integer> maxHeap = new MaxHeap<>();

        int n = 1000000;

        Random random = new Random();
        for (int i = 0; i < n; i++)
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        System.out.println("MaxHeap add method Test completed.");

        for (int i = 0; i < n / 2; i++)
            maxHeap.extractMax();
        System.out.println("MaxHeap extractMax method Test completed.");

        for (int i = 0; i < n / 2; i++)
            maxHeap.replace(random.nextInt(Integer.MAX_VALUE));
        System.out.println("MaxHeap replace method Test completed.");
    }

    public static double testHeap(Integer[] testData, boolean isHeapify) {
        long startTime = System.nanoTime();

        MaxHeap<Integer> maxHeap;

        // Heapify.
        if (isHeapify) {
            maxHeap = new MaxHeap<>(testData);
        } else {
            maxHeap = new MaxHeap<>();
            for (Integer num : testData) {
                maxHeap.add(num);
            }
        }

        // Without Heapify.
        int[] arr = new int[testData.length];
        for (int i = 0; i < testData.length; i++)
            arr[i] = maxHeap.extractMax();

        for (int i = 1; i < testData.length; i++)
            if (arr[i - 1] < arr[i])
                throw new IllegalArgumentException("Error");

        System.out.println("Test MaxHeap completed.");

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    @Test
    public void MaxHeapTestTwo() {
        int n = 1000000;

        Random random = new Random();
        Integer[] testData = new Integer[n];
        for (int i = 0; i < n; i++)
            testData[i] = random.nextInt(Integer.MAX_VALUE);

        double time1 = testHeap(testData, false);
        System.out.println("Without Heapify:" + time1 + " s");

        double time2 = testHeap(testData, true);
        System.out.println("Heapify:" + time2 + " s");
    }
}