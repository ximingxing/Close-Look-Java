package com.datastructure.tree;

import org.junit.Test;

/**
 * Description:
 * Created By xxm
 */
public class BSTTest {

    @Test
    public void add() {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums) {
            bst.add(num);
        }

        /////////////////////
        //        5        //
        //      /   \      //
        //     3     6     //
        //    / \     \    //
        //   2   4     8   //
        /////////////////////

//        bst.preOrder();
//        System.out.println();

//        bst.preOrderNR();

//        bst.levelOrder();

//        bst.inOrder();
//        System.out.println();
//
//        bst.postOrder();
//        System.out.println();

//        System.out.println(bst); // toString
    }

}