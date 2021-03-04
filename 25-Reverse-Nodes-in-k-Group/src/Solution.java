/**
 * Description:
 * <p>
 * Raw:   1 -> 2 -> 3 -> 4 -> 5
 * After: 2 -> 1 -> 4 -> 3 -> 5
 * <p>
 * Created By xxm
 */
public class Solution {
    public static ListNode reverseKGroup(ListNode head, int k) {
        // 统计链表长度
        int count = 0;
        for (ListNode temp = head; temp != null; temp = temp.next, count++) ;
        // 已翻转链表的头和尾
        ListNode rHead = null, rTail = null;
        // 将链表节点分为k个一组, 截取出子链表
        for (; count >= k; count -= k) {
            // 未翻转部分的头和尾, head的下一个节点
            ListNode group = head, nTail = group, next = head.next;
            // 将每个子链表单独进行翻转;
            for (int i = 1; i < k; i++) {
                head = next;
                next = head.next;
                head.next = group;
                group = head;
            }
            // 连接子链表
            if (rTail == null) {// 第一次翻转子链表
                rHead = group;
            } else { // 后续翻转, 将剩余子链表接至已翻转部分的尾部
                rTail.next = group;
            }
            rTail = nTail;
            head = next;
            rTail.next = next;
        }
        return rHead;
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
