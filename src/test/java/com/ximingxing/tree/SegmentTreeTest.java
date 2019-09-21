package com.ximingxing.tree;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Description:
 * Created By xxm
 */
public class SegmentTreeTest {

    @Test
    public void BuildSegmentTreeTest() {
        Integer[] nums = {-2, 0, 3, -5, 2, -1};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums, Integer::sum);
        System.out.println(segmentTree);

        System.out.println(segmentTree.query(0, 5));
        System.out.println(segmentTree.query(0, 2));
        System.out.println(segmentTree.query(3, 5));
        System.out.println(segmentTree.query(0, 1));
        System.out.println(segmentTree.query(2, 2));
        System.out.println(segmentTree.query(3, 4));
        System.out.println(segmentTree.query(5, 5));

    }

}