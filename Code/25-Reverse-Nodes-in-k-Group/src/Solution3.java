/**
 * Description:
 * <p>
 * 递归实现K个一组翻转链表
 * <p>
 * Created By xxm
 */
public class Solution3 {

    /* 翻转区间[a, b)内的节点 */
    private static ListNode reverse(ListNode a, ListNode b) {
        ListNode pre = null, cur = a, next = a;

        while (cur != b) {
            // 逐个节点翻转
            next = cur.next;
            cur.next = pre;
            // 更新指针位置
            pre = cur;
            cur = next;
        }
        // 翻转链表后, 头节点为pre
        return pre;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        // 区间[a,b)包含k个待翻转的节点
        ListNode a = head, b = head;

        for (int i = 0; i < k; i++) {
            // 不足 k 个，不需要反转，base case
            if (b == null) return head;
            b = b.next;
        }

        // 先反转以 head 开头的 k 个元素
        ListNode newHead = reverse(a, b);
        // 将第 k + 1 个元素作为 head 递归调用 reverseKGroup 函数
        // 并将上述两个过程连接起来
        a.next = reverseKGroup(b, k);
        return newHead;
    }

    public static void main(String[] args) {
        ListNode e = new ListNode(5);
        ListNode d = new ListNode(4, e);
        ListNode c = new ListNode(3, d);
        ListNode b = new ListNode(2, c);
        ListNode a = new ListNode(1, b);

        print(a);
        ListNode newHead = reverseKGroup(a, 2);
        System.out.println(newHead);
        print(newHead);
    }

    public static void print(ListNode head) {
        StringBuilder r = new StringBuilder();
        while (head != null) {
            if (head.next == null) {
                r.append(head.val);
            } else {
                r.append(head.val).append(" -> ");
            }
            head = head.next;
        }
        System.out.println(r.toString());
    }
}
