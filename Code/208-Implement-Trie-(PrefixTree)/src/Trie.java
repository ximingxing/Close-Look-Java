/**
 * Description:
 * <p>
 * 字典树的实现
 * <p>
 * Created By xxm
 */
public class Trie {
    // 用于存储 26 个英文字符
    private Trie[] children;
    // 用于标记从起始位置到当前位置的路径是否构成合法单词
    private boolean isEnd;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        // 用于遍历字典树的指针
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            // 将索引转化为[0 .. 25]之间
            int index = c - 'a';
            // 子节点不存在：创建一个新的子节点，记录在 children 数组的对应位置上，
            // 然后沿着指针移动到子节点，继续搜索下一个字符
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            // 子节点存在。沿着指针移动到子节点，继续处理下一个字符。
            node = node.children[index];
        }
        node.isEnd = true;
    }

    private Trie searchPrefix(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            // 子节点不存在。说明字典树中不包含该前缀，返回空指针。
            if (node.children[index] == null) {
                return null;
            }
            // 子节点存在。沿着指针移动到子节点，继续搜索下一个字符。
            node = node.children[index];
        }
        return node;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */