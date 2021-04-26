/**
 * Description:
 * <p>
 * Raw:   1 -> 2 -> 3 -> 4 -> 5
 * After: 2 -> 1 -> 4 -> 3 -> 5
 * <p>
 * Created By xxm
 */
public class Solution2 {
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 这里需要记录记录翻转链表前驱和后继;
        // 方便翻转完成后把已翻转部分和未翻转部分连接起来.
        // pre 指向待翻转链表的前驱节点, end 指向待翻转链表的末尾节点
        ListNode pre = dummy, end = dummy;

        while (end.next != null) {
            // 移动end指针到待翻转子链表到尾部
            for (int i = 0; i < k && end != null; i++, end = end.next) ;
            // 如果end移动k个节点为为null, 说明剩余链表节点总数不足k个
            if (end == null) break;

            // start 指向待翻转链表的头节点, next 指向未翻转链表的头节点
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null; // 断开 待翻转链表 与 未翻转链表
            // 翻转[start, end]区间
            pre.next = reverse(start);
            // 将已翻转部分和未翻转部分链接
            start.next = next;

            // 将pre换成下次要翻转的链表的头结点的前驱节点; 即start
            // 翻转结束, 将end置为下次要翻转的链表的头结点的的前驱节点; 即start
            pre = end = start;
        }
        return dummy.next;
    }

    private static ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next; // 保存当前节点后面的链表.
            cur.next = pre; // 将当前节点指向前一个节点.
            pre = cur; // preNode 指针向后移动, preNode指向当前节点.
            cur = next; // curNode指针向后移动, 下一个节点变成当前节点.
        }
        return pre;
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
