package datastructure.tree;

import datastructure.map.BSTMap;

/**
 * Description: Trie
 * Created By xxm
 */
public class Trie {

    // The definition of node
    private class Node {
        public boolean isWord;
        public BSTMap<Character, Node> next; // Multi-fork tree

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new BSTMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private Node root;
    private int size;

    public Trie() {
        root = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    /**
     * Add a word to trie.
     *
     * @param word word to add.
     */
    public void add(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null)
                cur.next.set(c, new Node()); // set char c as value of node
            cur = cur.next.get(c);
        }

        if (!cur.isWord) { // if true word is already contains
            cur.isWord = true;
            size++;
        }
    }

    /**
     * Recursive add a word to trie.
     *
     * @param word word to add.
     */
    public void addUseRecursion(String word) {
        _add(0, root, word);
    }

    private void _add(int i, Node node, String word) {
        char c = word.charAt(i);
        if (node.next.get(c) == null)
            node.next.set(c, new Node());
        node = node.next.get(c);

        if (i == word.length()) { // recursion stop condition
            return;
        }

        if (!node.isWord) {
            node.isWord = true;
            size++;
        }

        _add(i++, node, word);
    }

    /**
     * Determine if the element is in the trie.
     *
     * @param word word to find.
     * @return true if last c of word points node is word.
     */
    public boolean contains(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null)
                return false;
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }

}
