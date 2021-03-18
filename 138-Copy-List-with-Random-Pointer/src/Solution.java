import java.util.HashMap;

/**
 * Description:
 * <p>
 * HashMap
 * <p>
 * Created By xxm
 */
public class Solution {
    public Node copyRandomList(Node head) {
        // 统计链表长度
        int len = 0;
        // 建立链表节点到链表顺序到索引
        HashMap<Node, Integer> ind = new HashMap<>();
        for (Node temp = head; temp != null; temp = temp.next)
            ind.put(temp, len++);

        if (len == 0) return null;

        // 使用一个数组依次保存需要复制的链表节点
        // 这里使用数组保存链表节点是因为
        // 在第n个节点需要调整n-1个节点第next域指向自己, 方便回溯
        Node[] r = new Node[len];
        for (int i = 0; i < len; i++) {
            r[i] = new Node(0);
        }
        // 依次遍历被复制的链表
        for (int n = 0; head != null; head = head.next, n++) {
            // 复制链表节点的value
            r[n].val = head.val;
            // 依次链接需要复制的链表
            if (n > 0) {
                r[n - 1].next = r[n];
            }
            // 复制random域
            if (head.random != null) {
                r[n].random = r[ind.get(head.random)];
            }
        }
        return r[0];
    }
}
