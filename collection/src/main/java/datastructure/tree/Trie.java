package datastructure.tree;

import datastructure.map.BSTMap;

/**
 * Description: Trie
 * Created By xxm
 */
public class Trie {

    // node define of trie
    private class Node {
        public boolean isWord;
        public BSTMap<Character, Node> next;

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
     * @param word string
     */
    public void add(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null)
                cur.next.set(c, new Node());
            cur = cur.next.get(c);
        }

        if (!cur.isWord) { // word is new
            cur.isWord = true;
            size++;
        }
    }

    public void addUseRecursion(String word) {
        _add(0, root, word);
    }

    private void _add(int i, Node node, String word) {
        char c = word.charAt(i);
        if (node.next.get(c) == null)
            node.next.set(c, new Node());
        node = node.next.get(c);

        if (i == word.length()) { // stop condition
            return;
        }

        if (!node.isWord) { // word is new
            node.isWord = true;
            size++;
        }

        _add(i++, node, word);
    }
}
