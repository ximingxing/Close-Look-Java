package com.ximingxing.bstree;

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
     * Insert an element in bst using recursive algorithm.
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
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    /**
     * Returns {@code true} if this tree contains the specified element.
     * using recursive algorithm.
     * which node is the current root of the tree.
     */
    private boolean contains(Node node, E e) {

        if (node == null) return false;

        if (e.compareTo(node.e) == 0)
            return true;
        else if (e.compareTo(node.e) < 0)
            return contains(node.left, e);
        else  // e.compareTo(node.e) > 0
            return contains(node.right, e);
    }

    /**
     * PreOrder traversal.
     */
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {

        if (node == null) return;

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * InOrder traversal.
     */
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) return;

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    /**
     * PostOrder traversal.
     * Example:free the memory for bst.
     */
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    /**
     * toString method based on preOrder travel.
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateDepthString(depth)).append("NULL").append("\n");
            return;
        }

        res.append(generateDepthString(depth)).append(node.e).append("\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }
}