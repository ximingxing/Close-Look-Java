package com.ximingxing.tree;

/**
 * Description: SegmentTree
 * Created By xxm
 */
public class SegmentTree<E> {

    private E[] tree; // index
    private E[] data; // value
    private Merger<E> merger; // user-defined method (Merge interval rules)

    public SegmentTree(E[] arr, Merger<E> merger) {
        this.merger = merger;

        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++)
            data[i] = arr[i];

        tree = (E[]) new Object[4 * arr.length];
        buildSegmentTree(0, 0, data.length - 1);
    }

    /**
     * Create a SegmentTree representing the intervals [l...r] at the location of the treeIndex.
     *
     * @param treeIndex the index of current location
     * @param l         left end of the interval
     * @param r         right end of the interval
     */
    private void buildSegmentTree(int treeIndex, int l, int r) {

        // recursion stop rule: only one element in the interval
        if (l == r) {
            tree[treeIndex] = data[l];
            return;
        }

        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        // int mid = (l + r) / 2;
        int mid = l + (r - l) / 2; // to prevent overflow
        buildSegmentTree(leftTreeIndex, l, mid);
        buildSegmentTree(rightTreeIndex, mid + 1, r);

        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    public int getSize() {
        return data.length;
    }

    public E get(int index) {
        if (index < 0 || index >= data.length)
            throw new IllegalArgumentException("Index is illegal.");
        return data[index];
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    /**
     * Query the specify interval.
     *
     * @param queryL left end of interval.
     * @param queryR right end of interval.
     * @return the result of [queryL,queryR]
     */
    public E query(int queryL, int queryR) {
        if (queryL < 0 || queryL >= data.length ||
                queryR < 0 || queryR >= data.length || queryL > queryR)
            throw new IllegalArgumentException("Index is illegal.");

        return query(0, 0, data.length - 1, queryL, queryR);
    }

    /**
     * @param treeIndex current location.
     * @param l         left end of interval.
     * @param r         right end of interval.
     * @param queryL    left end of query interval.
     * @param queryR    right end of query interval.
     */
    private E query(int treeIndex, int l, int r, int queryL, int queryR) {

        if (l == queryL && r == queryR)
            return tree[treeIndex];

        int mid = l + (r - l) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        if (queryL >= mid + 1) // query interval in right half of the interval.
            return query(rightTreeIndex, mid + 1, r, queryL, queryR);
        else if (queryR <= mid) // query interval in left half of the interval.
            return query(leftTreeIndex, l, mid, queryL, queryR);

        // query interval contains left and right half of the interval.
        E leftResult = query(leftTreeIndex, l, mid, queryL, mid);
        E rightResult = query(rightTreeIndex, mid + 1, r, mid + 1, queryR);
        return merger.merge(leftResult, rightResult);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("[");
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null)
                res.append(tree[i]);
            else
                res.append("null");

            if (i != tree.length - 1)
                res.append(",");
        }
        res.append("]");
        return res.toString();
    }
}
