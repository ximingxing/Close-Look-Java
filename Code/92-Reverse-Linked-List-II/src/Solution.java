/**
 * Description:
 * <p>
 * 将需要翻转的链表截取出来单独翻转
 * 再将翻转后的链表拼接回原链表之中
 * <p>
 * Created By xxm
 */
public class Solution {
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0, head);

        // pre指向待翻转链表的前一个节点
        ListNode pre = dummy;
        for (int i = 0; i < left - 1; i++)
            pre = pre.next;

        // nRight指向待翻转链表的尾节点
        ListNode nRight = pre;
        for (int i = 0; i < right - left + 1; i++)
            nRight = nRight.next;

        // nLeft指向待翻转链表的头节点, newHead指向原链表剩余的表尾
        ListNode nLeft = pre.next;
        ListNode newHead = nRight.next;

        // 将待翻转链表从原链表中截取
        pre.next = null;
        nRight.next = null;

        // 翻转链表(这里是指截取出来的的子链表)
        ListNode r = null;
        ListNode cur = nLeft;
        while (cur != null) {
            ListNode temp = cur;
            cur = cur.next;
            temp.next = r;
            r = temp;
        }

        // 将翻转后的链表拼接回原链表
        pre.next = r;
        nLeft.next = newHead;

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
