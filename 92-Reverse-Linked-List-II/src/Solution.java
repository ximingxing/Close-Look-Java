/**
 * Description:
 * Created By xxm
 */
public class Solution {
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) return head;

        // 链表下标
        int n = 1;
        // 需要翻转的节点数量
        int len = right - left + 1;
        // 待翻转的链表的头和尾
        ListNode start = null, end = null;
        // 不需要翻转的链表的头和尾
        ListNode rawHead = head, rawTail = null;

        // 查找
        for (ListNode temp = head; temp.next != null && n <= right; temp = temp.next, n++) {
            if (n == left) {
                rawHead = temp;
                rawHead.next = null;
                start = temp;
            }
            if (n == right) {
                end = temp.next;
            }
        }

        // 翻转
        ListNode r = null;
        for (int i = 1; start != null && i <= len; i++) {
            ListNode t = start;
            start = start.next;
            t.next = r;
            r = t;
        }

        // 拼接
        ListNode temp = r;
        while (temp != null) {
            if (temp.next == null) {
                temp.next = end;
                break;
            }
            temp = temp.next;
        }

        return r;
    }

    //
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

    //
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
