/**
 * Description:
 * <p>
 * 旋转链表可以看作为链表找新的表头
 * <p>
 * Created By xxm
 */
public class Solution2 {
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        ListNode temp = head, prev = head;
        int len = 1;

        // 遍历链表记录长度
        while (temp.next != null) {
            ++len;
            temp = temp.next;
        }
        // 并将链表首位相接
        temp.next = head;

        // 寻找新的头节点
        for (int i = 0; i < len - (k %= len); ++i) {
            if (i == 0) {
                head = head.next;
            } else {
                head = head.next;
                prev = prev.next;
            }
        }
        // 断开链表
        prev.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode c = new ListNode(2);
        ListNode b = new ListNode(1, c);
        ListNode a = new ListNode(0, b);

        print(a);
        ListNode newHead = rotateRight(a, 4);
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
