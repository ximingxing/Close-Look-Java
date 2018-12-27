package com.ximingxing.binarySearchTree;

import java.util.LinkedList;

/**
 * Description: Binary Search Tree
 * Created By xxm
 */
public class BST<E extends Comparable<E>> {

    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Add a new element in bst.
     *
     * @param e
     */
    public void add(E e) {
        root = add(root, e);
    }

    /**
     * Insert an element in bst using recursive algorithm
     * which node is the root of the tree.
     *
     * @param node root of the tree.
     * @param e    the element need to insert.
     */
    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0)
            node.left = add(node.left, e);
        else if (e.compareTo(node.e) > 0)
            node.right = add(node.right, e);

        return node;
    }

    /**
     * Returns {@code true} if this tree contains the specified element.
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {

        if (root == null)
            return false;

        if (e.compareTo(node.e) == 0)
            return true;
        else if (e.compareTo(node.e) < 0)
            return contains(node.left, e);
        else  // e.compareTo(node.e) > 0
            return contains(node.right, e);

    }
}