/**
 * Description:
 * <p>
 * 使用双指针进行头插法:
 * 将q后面的元素依次删除, 然后添加到p后面.
 * <p>
 * Step1:
 * p    q
 * |    |
 * 1 -> 2 -> 3 -> 4 -> 5
 * <p>
 * Step2:
 * p         q
 * |         |
 * 1   3   2 -> 4 -> 5
 * <p>
 * Step3:
 * p       q
 * |       |
 * 1   4   3 -> 2 -> 5
 * <p>
 * Created By xxm
 */
public class Solution2 {
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);
        // p指向待翻转链表的头节点的前驱, q指向待翻转链表的头节点
        ListNode p = dummy, q = dummy.next;
        // 将p, q移动到对应位置
        for (int i = 0; i < left - 1; i++) {
            p = p.next;
            q = q.next;
        }
        // 头插法
        // 依次将q指向的节点移除, 将q指向节点的后继插入到p节点后继
        for (int i = left; i < right; i++) {
            ListNode t = q.next;
            q.next = q.next.next;
            t.next = p.next;
            p.next = t;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode e = new ListNode(5);
        ListNode d = new ListNode(4, e);
        ListNode c = new ListNode(3, d);
        ListNode b = new ListNode(2, c);
        ListNode a = new ListNode(1, b);

        print(a);
        ListNode newHead = reverseBetween(a, 2, 4);
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
