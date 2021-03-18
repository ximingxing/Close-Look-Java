/**
 * Description:
 * <p>
 * 镜像、复制、拆分
 * <p>
 * Created By xxm
 */
public class Solution2 {
    public Node copyRandomList(Node head) {
        // 镜像
        // 遍历被复制的链表, 在每个节点后插入一个其镜像节点
        for (Node temp = head; temp != null; temp = temp.next.next) {
            // t为temp的镜像
            Node t = new Node(temp.val);
            t.next = temp.next;
            temp.next = t;
        }
        // 复制
        // 将原始节点的next域和random域复制给镜像节点
        for (Node temp = head; temp != null; temp = temp.next.next) {
            // temp镜像的random域 指向 temp的random域的镜像
            // 这里原始节点random域可能为null
            temp.next.random = temp.random != null ? temp.random.next : null;
        }
        // 拆分
        // 从链表中将镜像节点拆分出来
        Node tail = new Node(0), r = tail;
        for (Node temp = head; temp != null; temp = temp.next) {
            // 将镜像节点链接到新链表后
            tail = tail.next = temp.next;
            temp.next = tail.next;
        }
        return r.next;
    }
}
